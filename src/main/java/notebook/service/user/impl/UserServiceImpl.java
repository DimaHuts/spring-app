package notebook.service.user.impl;

import notebook.entity.Role;
import notebook.entity.User;
import notebook.repository.UserRepository;
import notebook.service.common.BeanProvider;
import notebook.service.common.CryptPassword;
import notebook.service.role.RoleService;
import notebook.service.user.UserService;
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

  @Override
  public void cryptUserPassword(User user) {
    String cryptPassword = CryptPassword.crypt(user.getPassword());
    user.setPassword(cryptPassword);
  }

  @Override
  public void setRoleForUser(User user) {
    RoleService roleService = BeanProvider.getBean(RoleService.class);
    Role userRole = roleService.findRoleByPermissions(user.getPermissions());

    if (userRole != null) {
      user.setRole(userRole);
    }
  }
}
