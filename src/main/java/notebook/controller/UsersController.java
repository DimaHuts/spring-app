package notebook.controller;

import notebook.controller.wrappers.ExistUserWrapper;
import notebook.entity.User;
import notebook.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

  private final ApplicationContext context;

  @Autowired
  public UsersController(ApplicationContext context) {
    this.context = context;
  }

  @PostMapping("/exist/email")
    public Integer checkExistUser(@RequestBody ExistUserWrapper user) {
        return context
          .getBean(UserService.class)
          .findUserIdByEmail(user.getEmail());
    }

    @GetMapping("/getAll")
    public List<User> getAllUsers() {
        return context
          .getBean(UserService.class)
          .findAll();
    }
}
