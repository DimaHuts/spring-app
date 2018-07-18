package notebook.controller;

import notebook.controller.wrappers.LoginRequestWrapper;
import notebook.entity.User;
import notebook.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/api")
public class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequestWrapper reqWrapper) throws ServletException {
        User user = userService.login(reqWrapper);

        if(user==null)
            throw new ServletException("User not found");
        else
            return new ResponseEntity<LoginResponse>( new LoginResponse(Jwts.builder().setSubject(user.getEmail())
                    .claim("roles","user").setIssuedAt(new Date())
                    .signWith(SignatureAlgorithm.HS256, "secretkey").compact()), HttpStatus.OK);
    }

    private static class LoginResponse {
        String token;

        LoginResponse(final String token) {
            this.token = token;
        }
    }
}
