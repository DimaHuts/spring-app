package notebook.service.user;

import notebook.controller.wrappers.LoginRequestWrapper;
import notebook.entity.User;
import notebook.repository.UserRepository;
import notebook.service.common.CryptPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;

  @Autowired
  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public User findUserByEmail(String email) {
    return userRepository.findByEmail(email);
  }

  @Override
  public void saveUser(User user) {
    userRepository.save(user);
  }

  @Override
  public List<User> findAll() {
    return userRepository.findAllUsers();
  }

  @Override
  public Integer findUserIdByEmail(String email) {
    return userRepository.findUserIdByEmail(email);
  }

  @Override
  public User login(String login, String rawPassword) {
    User user = userRepository.findByEmail(login);

    if (CryptPassword.isEqualPasswords(rawPassword, user.getPassword())) {
      return user;
    }

    return null;
  }

}
