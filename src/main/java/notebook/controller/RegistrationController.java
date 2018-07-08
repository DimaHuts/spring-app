package notebook.controller;

import notebook.entity.User;
import notebook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

  private final UserService userService;

  @Autowired
  public RegistrationController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/api/register")
  public void createNewUser(@RequestBody User user) {
    userService.saveUser(user);
  }
}
