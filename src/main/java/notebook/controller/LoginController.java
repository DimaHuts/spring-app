package notebook.controller;

import notebook.controller.wrappers.LoginRequestWrapper;
import notebook.service.authentication.AuthenticationManagerInterface;
import notebook.service.common.BeanProvider;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoginController {

  @PostMapping("/login")
  public ResponseEntity<String> login(@RequestBody LoginRequestWrapper reqWrapper) {
    AuthenticationManagerInterface authenticationManager = BeanProvider.getBean(AuthenticationManagerInterface.class);

    authenticationManager.authenticate(reqWrapper.getUserLogin(), reqWrapper.getUserPassword());

    return new ResponseEntity<>("Success", HttpStatus.OK);
  }
}
