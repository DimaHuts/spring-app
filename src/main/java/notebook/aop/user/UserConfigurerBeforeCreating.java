package notebook.aop.user;

import notebook.entity.User;
import notebook.service.common.BeanProvider;
import notebook.service.user.cryptuserpassword.CryptUserPasswordService;
import notebook.service.user.updateuserrole.UpdateUserRoleService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserConfigurerBeforeCreating {
  @Before("execution(* notebook.controller.RegistrationController.createNewUser(..)) && args(user)")
  public void configureUserAfterRegistration(User user) {
    CryptUserPasswordService cryptUserPasswordService = BeanProvider.getBean(CryptUserPasswordService.class);
    cryptUserPasswordService.cryptUserPassword(user);

    UpdateUserRoleService updateUserRoleService = BeanProvider.getBean(UpdateUserRoleService.class);
    updateUserRoleService.updateUserRole(user);
  }
}
