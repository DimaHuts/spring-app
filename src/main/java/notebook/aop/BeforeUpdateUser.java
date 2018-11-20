package notebook.aop;

import notebook.entity.User;
import notebook.repository.UserRepository;
import notebook.service.common.BeanProvider;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BeforeUpdateUser {
  @Before("execution(* notebook.controller.UsersController.updateUser(..)) && args(user)")
  public void beforeUserUpdate(User user) {
    UserRepository userRepository = BeanProvider.getBean(UserRepository.class);

    User userFromDb = userRepository.getUserById(user.getId());

    if (userFromDb != null) {
      user.setPassword(userFromDb.getPassword());
    }
  }
}
