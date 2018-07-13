package notebook.controller;

import notebook.controller.wrappers.ExistUserWrapper;
import notebook.entity.User;
import notebook.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/exist/email")
    public Integer checkExistUser(@RequestBody ExistUserWrapper user) {
        return userService.findUserIdByEmail(user.getEmail());
    }

    @GetMapping("/getAll")
    public List<User> getAllUsers() {
        return userService.findAll();
    }
}
