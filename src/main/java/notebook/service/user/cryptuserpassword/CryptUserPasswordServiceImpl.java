package notebook.service.user.cryptuserpassword;

import notebook.entity.User;
import notebook.service.common.CryptPassword;
import org.springframework.stereotype.Service;

@Service
public class CryptUserPasswordServiceImpl implements CryptUserPasswordService {
  @Override
  public void cryptUserPassword(User user) {
    String cryptPassword = CryptPassword.crypt(user.getPassword());
    user.setPassword(cryptPassword);
  }
}
