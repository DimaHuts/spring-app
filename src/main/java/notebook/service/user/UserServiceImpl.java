package notebook.service.user;

import notebook.entity.User;
import notebook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
  private final ApplicationContext context;

  @Autowired
  public UserServiceImpl(ApplicationContext context) {
    this.context = context;
  }

  @Override
  public User findUserByEmail(final String email) {
    var userRepository = context.getBean(UserRepository.class);

    return userRepository.findByEmail(email);
  }

  @Override
  public void saveUser(User user) {
    var userRepository = context.getBean(UserRepository.class);

    userRepository.save(user);
  }

  @Override
  public List<User> findAll() {
    var userRepository = context.getBean(UserRepository.class);

    return userRepository.findAllUsers();
  }

  @Override
  public Integer findUserIdByEmail(String email) {
    var userRepository = context.getBean(UserRepository.class);

    return userRepository.findUserIdByEmail(email);
  }
}
