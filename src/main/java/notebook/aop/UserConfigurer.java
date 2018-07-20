package notebook.aop;

import notebook.entity.User;
import notebook.service.user.FirstConfigureUserInterface;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserConfigurer {
    private final FirstConfigureUserInterface firstConfigureUser;

    public UserConfigurer(FirstConfigureUserInterface firstConfigureUser) {
        this.firstConfigureUser = firstConfigureUser;
    }

    @Before("execution(* notebook.controller.RegistrationController.createNewUser(..)) && args(user)")
    public void configureUserAfterRegistration(User user) {
        firstConfigureUser.configureUser(user);
    }
}
