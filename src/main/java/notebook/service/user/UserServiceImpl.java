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
    return context
      .getBean(UserRepository.class)
      .findByEmail(email);
  }

  @Override
  public void saveUser(User user) {
    context
      .getBean(UserRepository.class)
      .save(user);
  }

  @Override
  public List<User> findAll() {
    return context
      .getBean(UserRepository.class)
      .findAllUsers();
  }

  @Override
  public Integer findUserIdByEmail(String email) {
    return context
      .getBean(UserRepository.class)
      .findUserIdByEmail(email);
  }
}
