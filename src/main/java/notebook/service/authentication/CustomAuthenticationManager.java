package notebook.service.authentication;

import notebook.factory.AuthenticationFactory;
import notebook.service.common.BeanProvider;
import notebook.service.common.SecurityContextHandler;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class CustomAuthenticationManager implements AuthenticationManagerInterface {
  @Override
  public void authenticate(String username, String password) {
    AuthenticationManager authenticationManager = BeanProvider.getBean(AuthenticationManager.class);
    Authentication userAuthenticationObject = AuthenticationFactory.getAuthenticationObject(username, password);

    Authentication objectAuthentication = authenticationManager.authenticate(userAuthenticationObject);

    SecurityContextHandler.setAuthentication(objectAuthentication);
  }
}
