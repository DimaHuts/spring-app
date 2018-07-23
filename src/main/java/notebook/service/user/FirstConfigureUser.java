package notebook.service.user;

import notebook.entity.User;
import notebook.enums.DefaultRoles;
import notebook.service.common.CryptPassword;
import org.springframework.stereotype.Service;

@Service
public class FirstConfigureUser implements FirstConfigureUserInterface {
  @Override
  public void configureUser(User user) {
    user.setPassword(
      CryptPassword.crypt(user.getPassword())
    );

    user.setRoles(DefaultRoles.USER.getRoles());
  }
}
