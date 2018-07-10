package notebook.config;

import notebook.service.login.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  private final BCryptPasswordEncoder bCryptPasswordEncoder;
  private final CustomUserDetailService customUserDetailService;

  @Autowired
  public SecurityConfiguration(BCryptPasswordEncoder bCryptPasswordEncoder,
                               CustomUserDetailService customUserDetailService) {

    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    this.customUserDetailService = customUserDetailService;
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth
      .userDetailsService(customUserDetailService)
      .passwordEncoder(bCryptPasswordEncoder);
  }

  @Override
  protected void configure(HttpSecurity httpSecurity) throws Exception {

    httpSecurity.
      authorizeRequests()
      .antMatchers("/api/users/exist/email").permitAll()
      .antMatchers("/login").permitAll()
      .antMatchers("/api/register").permitAll()
      .anyRequest().authenticated()
      .and()
      .csrf()
      .disable()
      .formLogin()
      .loginPage("/login")
      .failureUrl("/login?error=true")
//      .defaultSuccessUrl("/admin/home")
      .usernameParameter("email")
      .passwordParameter("password")
      .and()
      .logout()
      .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
      .and();
//      .logoutSuccessUrl("/").and()
//      .exceptionHandling()
//      .accessDeniedPage("/access-denied");
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    web
      .ignoring()
      .antMatchers("/resources/**", "/static/**", "/images/**");
  }
}
