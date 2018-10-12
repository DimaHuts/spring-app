package notebook.controller;

import notebook.controller.wrappers.ExistUserWrapper;
import notebook.dto.UserDto;
import notebook.entity.User;
import notebook.service.common.BeanProvider;
import notebook.service.common.ContextManagerInterface;
import notebook.service.common.dto.Converter;
import notebook.service.user.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {
  @PostMapping("/exist/email")
    public Integer checkExistUser(@RequestBody ExistUserWrapper user) {
      var userService = BeanProvider.getBean(UserService.class);

      return userService.findUserIdByEmail(user.getEmail());
    }

    @GetMapping("/getAll")
    public List<User> getAllUsers() {
      var userService = BeanProvider.getBean(UserService.class);

      return userService.findAll();
    }

    @GetMapping("/get/current")
    public UserDto getCurrentUser() {
      var contextManager = BeanProvider.getBean(ContextManagerInterface.class);
      var userFromContext = contextManager.getUserFromContext();

      return (UserDto)Converter.convert(userFromContext, new UserDto());
    }
}
