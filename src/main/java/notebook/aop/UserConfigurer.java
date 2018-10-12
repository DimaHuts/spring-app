package notebook.aop;

import notebook.entity.User;
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
    var firstConfigureUser = BeanProvider.getBean(FirstConfigureUserInterface.class);

    firstConfigureUser.configureUser(user);
  }
}
