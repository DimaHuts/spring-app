package notebook.service.authentication.authenticationmanager;

import notebook.service.authentication.securitycontexthandler.SecurityContextHandler;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class CustomAuthenticationManager implements AuthenticationManagerInterface {
  @Override
  public void authenticate(Authentication authentication) {
    SecurityContextHandler securityContextHandler = new SecurityContextHandler(authentication);
    securityContextHandler.setSecurityContext();
  }
}
