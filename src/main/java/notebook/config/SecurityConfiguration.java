package notebook.config;

import notebook.security.CustomLogoutSuccessHandler;
import notebook.security.RestAuthenticationEntryPoint;
import notebook.service.authentication.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  private final BCryptPasswordEncoder bCryptPasswordEncoder;
  private final CustomUserDetailService customUserDetailService;
  private final RestAuthenticationEntryPoint restAuthenticationEntryPoint;
  private final CustomLogoutSuccessHandler logoutSuccessHandler;

  @Autowired
  public SecurityConfiguration(BCryptPasswordEncoder bCryptPasswordEncoder,
                               CustomUserDetailService customUserDetailService,
                               RestAuthenticationEntryPoint restAuthenticationEntryPoint,
                               CustomLogoutSuccessHandler logoutSuccessHandler) {

    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    this.customUserDetailService = customUserDetailService;
    this.restAuthenticationEntryPoint = restAuthenticationEntryPoint;
    this.logoutSuccessHandler = logoutSuccessHandler;
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth
      .userDetailsService(customUserDetailService)
      .passwordEncoder(bCryptPasswordEncoder);
  }

  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

  @Override
  protected void configure(HttpSecurity httpSecurity) throws Exception {
    httpSecurity.
      authorizeRequests()
        .antMatchers("/api/login").permitAll()
        .antMatchers("/api/register").permitAll()
        .anyRequest().authenticated()
        .and()
      .csrf()
      .disable()
      .exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint).and()
      .logout()
            .logoutUrl("/api/logout")
            .logoutSuccessHandler(logoutSuccessHandler);
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    web
      .ignoring()
      .antMatchers("/resources/**", "/static/**", "/images/**");
  }
}
