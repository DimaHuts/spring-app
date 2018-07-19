package notebook.controller;

import notebook.controller.wrappers.LoginRequestWrapper;
import notebook.service.authentication.AuthenticationManagerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoginController {

    private AuthenticationManagerInterface authenticationManager;

    @Autowired
    public LoginController(AuthenticationManagerInterface authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestWrapper reqWrapper) {
        authenticationManager.authenticate(
                reqWrapper.getUserLogin(), reqWrapper.getUserPassword()
        );

        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
