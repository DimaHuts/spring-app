package notebook.service.common;

import notebook.entity.User;
import notebook.service.user.findUserByEmail.FindUserByEmailService;
import org.springframework.stereotype.Service;

@Service
public class ContextManager implements ContextManagerInterface {
  @Override
  public User getUserFromContext() {
    String userName = getPrincipal().getUsername();
    FindUserByEmailService findUserByEmailService = BeanProvider.getBean(FindUserByEmailService.class);

    return findUserByEmailService.findUserByEmail(userName);
  }
}
