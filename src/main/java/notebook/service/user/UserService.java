package notebook.service.user;

import notebook.entity.User;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserService {
  User findUserByEmail(String email);
  void saveUser(User user);
  List<User> findAll();
  Integer findUserIdByEmail(@Param("email") String email);
}
