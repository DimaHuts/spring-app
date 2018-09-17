package notebook.controller;

import notebook.controller.wrappers.ExistUserWrapper;
import notebook.dto.UserDto;
import notebook.entity.User;
import notebook.service.common.ContextManagerInterface;
import notebook.service.common.dto.Converter;
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
      var userService = context.getBean(UserService.class);

      return userService.findUserIdByEmail(user.getEmail());
    }

    @GetMapping("/getAll")
    public List<User> getAllUsers() {
      var userService = context.getBean(UserService.class);

      return userService.findAll();
    }

    @GetMapping("/get/current")
    public UserDto getCurrentUser() {
      var contextManager = context.getBean(ContextManagerInterface.class);
      var userFromContext = contextManager.getUserFromContext();

      return (UserDto)Converter.convert(userFromContext, new UserDto());
    }
}
