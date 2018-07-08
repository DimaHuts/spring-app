package notebook.service;

import notebook.entity.Role;
import notebook.entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collections;
import java.util.HashSet;

public interface FirstConfigureUser {

  static void configureUser(User user) {
    user.setPassword(
      (new BCryptPasswordEncoder()).encode(user.getPassword())
    );

    user.setRoles(new byte[1]);
  }
}
