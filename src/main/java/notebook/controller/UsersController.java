package notebook.controller;

import notebook.controller.wrappers.ExistUserWrapper;
import notebook.dto.UserDto;
import notebook.entity.User;
import notebook.service.common.BeanProvider;
import notebook.service.common.CurrentUserFetcher;
import notebook.service.common.dto.Converter;
import notebook.service.user.UserService;
import notebook.service.user.findAllUsers.FindAllUsersService;
import notebook.service.user.findUserByEmail.FindUserByEmailService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {
  @PostMapping("/exist/email")
  public long checkExistUser(@RequestBody ExistUserWrapper user) {
    FindUserByEmailService findUserByEmailService = BeanProvider.getBean(FindUserByEmailService.class);

    return findUserByEmailService.findUserByEmail(user.getEmail()).getId();
  }

  @GetMapping("/getAll")
  public List<User> getAllUsers() {
    FindAllUsersService findAllUsersService = BeanProvider.getBean(FindAllUsersService.class);

    return findAllUsersService.findAll();
  }

  @GetMapping("/get/current")
  public UserDto getCurrentUser() {
    User authenticatedUser = CurrentUserFetcher.getCurrentUser();

    return Converter.convert(authenticatedUser, UserDto.class);
  }

  @PostMapping("/userUpdate")
  public void updateUser(@RequestBody User user) {
    UserService userService = BeanProvider.getBean(UserService.class);

    userService.saveUser(user);
  }
}
