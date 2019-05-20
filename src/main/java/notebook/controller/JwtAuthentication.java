package notebook.controller;

import notebook.controller.wrappers.LoginRequestWrapper;
import notebook.factory.AuthenticationFactory;
import notebook.util.jwt.JwtTokenProvider;
import notebook.service.authentication.authenticationmanager.AuthenticationManagerInterface;
import notebook.service.common.BeanProvider;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jwt-auth")
public class JwtAuthentication {
  @PostMapping("/signin")
  public String authenticateUser(@RequestBody LoginRequestWrapper loginRequest) {
    AuthenticationFactory authenticationFactory = new AuthenticationFactory();
    Authentication authentication = authenticationFactory.getAuthenticationObject(loginRequest.getUserLogin(), loginRequest.getUserPassword());

    AuthenticationManagerInterface authenticationManager = BeanProvider.getBean(AuthenticationManagerInterface.class);
    authenticationManager.authenticate(authentication);

    JwtTokenProvider jwtTokenProvider = BeanProvider.getBean(JwtTokenProvider.class);

    return jwtTokenProvider.generateToken(authentication);
  }
}
