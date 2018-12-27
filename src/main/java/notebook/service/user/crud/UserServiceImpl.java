package notebook.service.user.crud;

import notebook.entity.User;
import notebook.repository.user.CrudUserRepository;
import notebook.service.common.BeanProvider;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
  @Override
  public void saveUser(User user) {
  	CrudUserRepository userRepository = BeanProvider.getBean(CrudUserRepository.class);

    userRepository.save(user);
  }
}
