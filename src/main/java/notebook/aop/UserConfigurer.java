package notebook.aop;

import notebook.entity.User;
import notebook.service.user.FirstConfigureUserInterface;
import notebook.service.user.UserService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserConfigurer {

  private final ApplicationContext context;

  @Autowired
  public UserConfigurer(ApplicationContext context) {
    this.context = context;
  }

  @Before("execution(* notebook.controller.RegistrationController.createNewUser(..)) && args(user)")
  public void configureUserAfterRegistration(User user) {
    context
      .getBean(FirstConfigureUserInterface.class)
      .configureUser(user);
  }
}
