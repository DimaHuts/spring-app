package notebook.service.authentication;

import notebook.factory.AuthenticationFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class CustomAuthenticationManager implements AuthenticationManagerInterface {

  private final ApplicationContext context;

  @Autowired
  public CustomAuthenticationManager(ApplicationContext context) {
    this.context = context;
  }

  @Override
  public void authenticate(String username, String password) {
    var authenticationManager = context.getBean(AuthenticationManager.class);
    var userAuthenticationObject = AuthenticationFactory.getAuthenticationObject(username, password);

    var objectAuthentication = authenticationManager.authenticate(userAuthenticationObject);

    SecurityContextHolder
      .getContext()
      .setAuthentication(objectAuthentication);
  }
}
