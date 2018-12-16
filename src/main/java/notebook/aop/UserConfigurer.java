package notebook.aop;

import notebook.entity.User;
import notebook.repository.UserRepository;
import notebook.service.common.BeanProvider;
import notebook.service.user.FirstConfigureUserInterface;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserConfigurer {
  @Before("execution(* notebook.controller.RegistrationController.createNewUser(..)) && args(user)")
  public void configureUserAfterRegistration(User user) {
    FirstConfigureUserInterface firstConfigureUser = BeanProvider.getBean(FirstConfigureUserInterface.class);

    firstConfigureUser.configureUser(user);
  }

  @Before("execution(* notebook.controller.UsersController.updateUser(..)) && args(user)")
  public void beforeUserUpdate(User user) {
    UserRepository userRepository = BeanProvider.getBean(UserRepository.class);

    User userFromDb = userRepository.getUserById(user.getId());

    if (userFromDb != null) {
      user.setPassword(userFromDb.getPassword());
    }
  }
}
