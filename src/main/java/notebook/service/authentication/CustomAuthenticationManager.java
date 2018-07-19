package notebook.service.authentication;

import notebook.factory.AuthenticationFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class CustomAuthenticationManager implements AuthenticationManagerInterface {
    private AuthenticationManager authenticationManager;

    @Autowired
    public CustomAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public void authenticate(String username, String password) {
        SecurityContextHolder.getContext().setAuthentication(
                authenticationManager.authenticate(
                        AuthenticationFactory.getAuthenticationObject(username, password)
                )
        );
    }
}
