package notebook.config;

import notebook.security.CustomLogoutSuccessHandler;
import notebook.security.MySavedRequestAwareAuthenticationSuccessHandler;
import notebook.security.RestAuthenticationEntryPoint;
import notebook.service.authentication.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  private final BCryptPasswordEncoder bCryptPasswordEncoder;
  private final CustomUserDetailService customUserDetailService;
  private final RestAuthenticationEntryPoint restAuthenticationEntryPoint;

  @Autowired
  public SecurityConfiguration(BCryptPasswordEncoder bCryptPasswordEncoder,
                               CustomUserDetailService customUserDetailService,
                               RestAuthenticationEntryPoint restAuthenticationEntryPoint) {

    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    this.customUserDetailService = customUserDetailService;
    this.restAuthenticationEntryPoint = restAuthenticationEntryPoint;
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
      .exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint).and();
  }

  @Bean
  public MySavedRequestAwareAuthenticationSuccessHandler mySuccessHandler(){
    return new MySavedRequestAwareAuthenticationSuccessHandler();
  }
  @Bean
  public SimpleUrlAuthenticationFailureHandler myFailureHandler(){
    return new SimpleUrlAuthenticationFailureHandler();
  }
  @Bean
  public CustomLogoutSuccessHandler myLogoutSuccessHandler(){
    return new CustomLogoutSuccessHandler();
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    web
      .ignoring()
      .antMatchers("/resources/**", "/static/**", "/images/**");
  }
}
