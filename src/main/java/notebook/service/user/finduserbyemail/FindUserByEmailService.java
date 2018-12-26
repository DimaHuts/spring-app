package notebook.service.user.finduserbyemail;

import notebook.entity.User;

public interface FindUserByEmailService {
  User findUserByEmail(String email);
}
