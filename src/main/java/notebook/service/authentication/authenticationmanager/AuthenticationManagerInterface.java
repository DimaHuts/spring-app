package notebook.service.authentication.authenticationmanager;

import org.springframework.security.core.Authentication;

public interface AuthenticationManagerInterface {
  void authenticate(Authentication authentication);
}
