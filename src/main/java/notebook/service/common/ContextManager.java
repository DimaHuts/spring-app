package notebook.service.common;

import notebook.entity.User;
import notebook.service.user.UserService;
import org.springframework.stereotype.Service;

@Service
public class ContextManager implements ContextManagerInterface {
  @Override
  public User getUserFromContext() {
    var userService = BeanProvider.getBean(UserService.class);
    var userName = getPrincipal().getUsername();

    return userService.findUserByEmail(userName);
  }
}
