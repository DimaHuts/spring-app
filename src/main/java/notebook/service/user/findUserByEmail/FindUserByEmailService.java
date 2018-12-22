package notebook.service.user.findUserByEmail;

import notebook.entity.User;

public interface FindUserByEmailService {
  User findUserByEmail(String email);
}
