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
    UserRepository userRepository = BeanProvider.getBean(UserRepository.class);

    return userRepository.findByEmail(email);
  }

  @Override
  public void saveUser(User user) {
    UserRepository userRepository = BeanProvider.getBean(UserRepository.class);

    userRepository.save(user);
  }

  @Override
  public List<User> findAll() {
    UserRepository userRepository = BeanProvider.getBean(UserRepository.class);

    return userRepository.findAllUsers();
  }

  @Override
  public long findUserIdByEmail(String email) {
    UserRepository userRepository = BeanProvider.getBean(UserRepository.class);

    User userFromBd = userRepository.findByEmail(email);

    if (userFromBd != null) {
      return userFromBd.getId();
    }

    return 0;
  }
}
