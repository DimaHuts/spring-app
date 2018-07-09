package notebook.service.user;

import notebook.entity.User;
import notebook.enums.DefaultRoles;
import notebook.service.common.CryptPassword;

public interface FirstConfigureUser {

  static void configureUser(User user) {
    user.setPassword(
            CryptPassword.crypt(user.getPassword())
    );

    user.setRoles(DefaultRoles.USER.getRoles());
  }
}
