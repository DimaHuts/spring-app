package notebook.factory;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

public interface AuthenticationFactory {
    static Authentication getAuthenticationObject(String username, String password) {
        return new UsernamePasswordAuthenticationToken(username, password);
    }
}
