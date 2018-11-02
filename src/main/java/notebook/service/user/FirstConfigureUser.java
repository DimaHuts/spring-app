package notebook.service.user;

import notebook.entity.User;
import notebook.enums.DefaultRoles;
import notebook.service.common.CryptPassword;
import org.springframework.stereotype.Service;

@Service
public class FirstConfigureUser implements FirstConfigureUserInterface {
  @Override
  public void configureUser(User user) {
    String cryptPassword = CryptPassword.crypt(user.getPassword());

    user.setPassword(cryptPassword);

    user.setRoles(DefaultRoles.USER.getRoles());
  }
}
