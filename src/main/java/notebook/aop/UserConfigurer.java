package notebook.aop;

import notebook.entity.User;
import notebook.service.common.BeanProvider;
import notebook.service.user.firstConfigureUser.FirstConfigureUserService;
import notebook.service.user.getUserById.GetUserByIdService;
import notebook.service.user.updateUserRole.UpdateUserRoleService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserConfigurer {
  @Before("execution(* notebook.controller.RegistrationController.createNewUser(..)) && args(user)")
  public void configureUserAfterRegistration(User user) {
    FirstConfigureUserService firstConfigureUser = BeanProvider.getBean(FirstConfigureUserService.class);

    firstConfigureUser.configureUser(user);
  }

  @Before("execution(* notebook.controller.UsersController.updateUser(..)) && args(user)")
  public void beforeUserUpdate(User user) {
    GetUserByIdService getUserByIdService = BeanProvider.getBean(GetUserByIdService.class);

    User userFromDb = getUserByIdService.getUserById(user.getId());

    if (userFromDb != null) {
      user.setPassword(userFromDb.getPassword());
    }

    UpdateUserRoleService updateUserRoleService = BeanProvider.getBean(UpdateUserRoleService.class);
    updateUserRoleService.updateUserRole(user);
  }
}
