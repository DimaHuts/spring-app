package notebook.controller;

import notebook.controller.wrappers.ExistUserWrapper;
import notebook.entity.User;
import notebook.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/users/exist/email")
    public Integer checkExistUser(@RequestBody ExistUserWrapper user) {
        return userService.findUserIdByEmail(user.getEmail());
    }

    @GetMapping("/api/users/getAll")
    public List<User> getAllUsers() {
        return userService.findAll();
    }
}
