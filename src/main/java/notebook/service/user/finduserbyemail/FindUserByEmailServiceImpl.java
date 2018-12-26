package notebook.service.user.finduserbyemail;

import notebook.entity.User;
import notebook.repository.user.FindUserByEmailRepository;
import notebook.service.common.BeanProvider;
import org.springframework.stereotype.Service;

@Service
public class FindUserByEmailServiceImpl implements FindUserByEmailService {
  @Override
  public User findUserByEmail(String email) {
    FindUserByEmailRepository findUserByEmailRepository = BeanProvider.getBean(FindUserByEmailRepository.class);

    return findUserByEmailRepository.findByEmail(email);
  }
}
