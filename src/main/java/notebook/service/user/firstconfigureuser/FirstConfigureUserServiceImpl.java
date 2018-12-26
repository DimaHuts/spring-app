package notebook.service.user.firstconfigureuser;

import notebook.entity.User;
import notebook.service.common.BeanProvider;
import notebook.service.user.cryptuserpassword.CryptUserPasswordService;
import notebook.service.user.updateuserrole.UpdateUserRoleService;
import org.springframework.stereotype.Service;

@Service
public class FirstConfigureUserServiceImpl implements FirstConfigureUserService {
  @Override
  public void configureUser(User user) {
    CryptUserPasswordService cryptUserPasswordService = BeanProvider.getBean(CryptUserPasswordService.class);
    cryptUserPasswordService.cryptUserPassword(user);

    UpdateUserRoleService updateUserRoleService = BeanProvider.getBean(UpdateUserRoleService.class);
    updateUserRoleService.updateUserRole(user);
  }
}
