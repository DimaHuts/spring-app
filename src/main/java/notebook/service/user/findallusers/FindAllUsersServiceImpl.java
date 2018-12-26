package notebook.service.user.findallusers;

import notebook.entity.User;
import notebook.repository.user.FindAllUsersRepository;
import notebook.service.common.BeanProvider;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllUsersServiceImpl implements FindAllUsersService {
  @Override
  public List<User> findAll() {
    FindAllUsersRepository findAllUsersRepository = BeanProvider.getBean(FindAllUsersRepository.class);

    return  findAllUsersRepository.findAllUsers();
  }
}
