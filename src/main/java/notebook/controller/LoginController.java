package notebook.controller;

import notebook.controller.wrappers.LoginRequestWrapper;
import notebook.factory.AuthenticationFactory;
import notebook.service.authentication.authenticationmanager.AuthenticationManagerInterface;
import notebook.service.common.BeanProvider;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoginController {

  @PostMapping("/login")
  public ResponseEntity<String> login(@RequestBody LoginRequestWrapper reqWrapper) {
    AuthenticationFactory authenticationFactory = new AuthenticationFactory();
    Authentication authentication = authenticationFactory.getAuthenticationObject(reqWrapper.getUserLogin(), reqWrapper.getUserPassword());

    AuthenticationManagerInterface authenticationManager = BeanProvider.getBean(AuthenticationManagerInterface.class);
    authenticationManager.authenticate(authentication);

    return new ResponseEntity<>("Success", HttpStatus.OK);
  }
}
