package notebook.service.authentication;

import notebook.factory.AuthenticationFactory;
import notebook.service.common.SecurityContextHandler;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class CustomAuthenticationManager implements AuthenticationManagerInterface {
  @Override
  public void authenticate(String username, String password) {
    AuthenticationFactory authenticationFactory = new AuthenticationFactory();
    Authentication authentication = authenticationFactory.getAuthenticationObject(username, password);

    SecurityContextHandler.setAuthentication(authentication);
  }
}
