package notebook.service.user.getUserById;

import notebook.entity.User;
import notebook.repository.user.GetUserByIdRepository;
import notebook.service.common.BeanProvider;
import org.springframework.stereotype.Service;

@Service
public class GetUserByIdServiceImpl implements GetUserByIdService {
  @Override
  public User getUserById(long id) {
    GetUserByIdRepository getUserByIdRepository = BeanProvider.getBean(GetUserByIdRepository.class);

    return getUserByIdRepository.getUserById(id);
  }
}
