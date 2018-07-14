package notebook.controller;

import notebook.controller.wrappers.LoginRequestWrapper;
import notebook.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;

@RestController
@RequestMapping("/api")
public class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestWrapper reqWrapper) throws ServletException {
        if(userService.login(reqWrapper.getUserLogin(), reqWrapper.getUserPassword()) == null) {
            throw new ServletException("User not found");
        }
        else {
            return new ResponseEntity<>("Success", HttpStatus.OK);
        }
    }
}
