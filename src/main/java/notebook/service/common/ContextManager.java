package notebook.service.common;

import notebook.entity.User;
import notebook.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class ContextManager implements ContextManagerInterface {
  private final ApplicationContext context;

  @Autowired
  public ContextManager(ApplicationContext context) {
    this.context = context;
  }

  @Override
  public User getUserFromContext() {
    var userService = context.getBean(UserService.class);
    var userName = getPrincipal().getUsername();

    return userService.findUserByEmail(userName);
  }
}
