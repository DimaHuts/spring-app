package notebook.service.user;

import notebook.entity.User;
import notebook.service.common.BeanProvider;
import org.springframework.stereotype.Service;

@Service
public class FirstConfigureUser implements FirstConfigureUserInterface {
  @Override
  public void configureUser(User user) {
    UserService userService = BeanProvider.getBean(UserService.class);

    userService.cryptUserPassword(user);
    userService.setRoleForUser(user);
  }
}
