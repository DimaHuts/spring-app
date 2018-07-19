package notebook.service.user;

import notebook.controller.wrappers.LoginRequestWrapper;
import notebook.entity.User;

import java.util.List;

public interface UserService {
  User findUserByEmail(String email);

  void saveUser(User user);

  List<User> findAll();

  Integer findUserIdByEmail(String email);

  User login(String login, String rawPassword);
}
