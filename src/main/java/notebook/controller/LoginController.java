package notebook.controller;

import notebook.controller.wrappers.LoginRequestWrapper;
import notebook.service.authentication.AuthenticationManagerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoginController {

  private final ApplicationContext context;

  @Autowired
  public LoginController(ApplicationContext context) {
    this.context = context;
  }

  @PostMapping("/login")
  public ResponseEntity<String> login(@RequestBody LoginRequestWrapper reqWrapper) {
    context
      .getBean(AuthenticationManagerInterface.class)
      .authenticate(reqWrapper.getUserLogin(), reqWrapper.getUserPassword());

      return new ResponseEntity<>("Success", HttpStatus.OK);
  }
}
