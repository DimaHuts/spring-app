package notebook.service.user;

import notebook.entity.User;
import notebook.service.common.BeanProvider;
import notebook.service.user.cryptUserPassword.CryptUserPasswordService;
import notebook.service.user.updateUserRole.UpdateUserRoleService;
import org.springframework.stereotype.Service;

@Service
public class FirstConfigureUser implements FirstConfigureUserInterface {
  @Override
  public void configureUser(User user) {
    CryptUserPasswordService cryptUserPasswordService = BeanProvider.getBean(CryptUserPasswordService.class);
    cryptUserPasswordService.cryptUserPassword(user);

    UpdateUserRoleService updateUserRoleService = BeanProvider.getBean(UpdateUserRoleService.class);
    updateUserRoleService.updateUserRole(user);
  }
}
