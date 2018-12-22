package notebook.controller;

import notebook.entity.User;
import notebook.service.common.BeanProvider;
import notebook.service.user.crud.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
  @PostMapping("/api/register")
  public void createNewUser(@RequestBody User user) {
    UserService userService = BeanProvider.getBean(UserService.class);

    userService.saveUser(user);
  }
}
