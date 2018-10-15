package notebook.service.user;

import notebook.entity.User;
import notebook.repository.UserRepository;
import notebook.service.common.BeanProvider;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
  @Override
  public User findUserByEmail(final String email) {
    var userRepository = BeanProvider.getBean(UserRepository.class);

    return userRepository.findByEmail(email);
  }

  @Override
  public void saveUser(User user) {
    var userRepository = BeanProvider.getBean(UserRepository.class);

    userRepository.save(user);
  }

  @Override
  public List<User> findAll() {
    var userRepository = BeanProvider.getBean(UserRepository.class);

    return userRepository.findAllUsers();
  }

  @Override
  public Integer findUserIdByEmail(String email) {
    var userRepository = BeanProvider.getBean(UserRepository.class);

    return userRepository.findUserIdByEmail(email);
  }
}
