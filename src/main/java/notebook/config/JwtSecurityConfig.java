package notebook.config;

import notebook.security.RestAuthenticationEntryPoint;
import notebook.security.jwt.JwtAuthenticationFilter;
import notebook.service.authentication.CustomUserDetailService;
import notebook.service.common.BeanProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
  prePostEnabled = true
)
public class JwtSecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
    CustomUserDetailService customUserDetailService = BeanProvider.getBean(CustomUserDetailService.class);
    BCryptPasswordEncoder bCryptPasswordEncoder = BeanProvider.getBean(BCryptPasswordEncoder.class);

    authenticationManagerBuilder
      .userDetailsService(customUserDetailService)
      .passwordEncoder(bCryptPasswordEncoder);
  }

  @Bean(BeanIds.AUTHENTICATION_MANAGER)
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

  protected void configure(HttpSecurity http) throws Exception {
    RestAuthenticationEntryPoint restAuthenticationEntryPoint = BeanProvider.getBean(RestAuthenticationEntryPoint.class);
    JwtAuthenticationFilter jwtAuthenticationFilter = BeanProvider.getBean(JwtAuthenticationFilter.class);
    http
      .cors()
      .and()
      .csrf()
      .disable()
      .exceptionHandling()
      .authenticationEntryPoint(restAuthenticationEntryPoint)
      .and()
      .sessionManagement()
      .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
      .and()
      .authorizeRequests()
      .antMatchers("/",
        "/favicon.ico",
        "/**/*.png",
        "/**/*.gif",
        "/**/*.svg",
        "/**/*.jpg",
        "/**/*.html",
        "/**/*.css",
        "/**/*.js")
      .permitAll()
      .antMatchers("/api/jwt-auth/signin").permitAll()
      .anyRequest()
      .authenticated();

    // Add our custom JWT security filter
    http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

  }
}
