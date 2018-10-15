package notebook.service.authentication;

import notebook.factory.AuthenticationFactory;
import notebook.service.common.BeanProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class CustomAuthenticationManager implements AuthenticationManagerInterface {
  @Override
  public void authenticate(String username, String password) {
    var authenticationManager = BeanProvider.getBean(AuthenticationManager.class);
    var userAuthenticationObject = AuthenticationFactory.getAuthenticationObject(username, password);

    var objectAuthentication = authenticationManager.authenticate(userAuthenticationObject);

    SecurityContextHolder
      .getContext()
      .setAuthentication(objectAuthentication);
  }
}
