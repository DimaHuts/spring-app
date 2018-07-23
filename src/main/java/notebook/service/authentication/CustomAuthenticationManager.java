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
    SecurityContextHolder
      .getContext()
      .setAuthentication(
        context
          .getBean(AuthenticationManager.class)
          .authenticate(
            AuthenticationFactory.getAuthenticationObject(username, password)
          )
    );
  }
}
