package notebook.controller;

import notebook.entity.User;
import notebook.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

  private final ApplicationContext context;

  @Autowired
  public RegistrationController(ApplicationContext context) {
    this.context = context;
  }

  @PostMapping("/api/register")
  public void createNewUser(@RequestBody User user) {
    context
      .getBean(UserService.class)
      .saveUser(user);
  }
}
