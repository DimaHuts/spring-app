package notebook.controller;

import notebook.controller.wrappers.ExistUserWrapper;
import notebook.entity.User;
import notebook.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/users/exist/email")
    public ResponseEntity<Integer> checkExistUser(@RequestBody ExistUserWrapper user) {
        return new ResponseEntity<>(userService.findUserIdByEmail(user.getEmail()), HttpStatus.OK);
    }
}
