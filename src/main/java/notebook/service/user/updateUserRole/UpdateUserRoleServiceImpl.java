package notebook.service.user.updateUserRole;

import notebook.entity.Role;
import notebook.entity.User;
import notebook.service.common.BeanProvider;
import notebook.service.role.findRoleByPermissions.FindRoleByPermissionsService;
import org.springframework.stereotype.Service;

@Service
public class UpdateUserRoleServiceImpl implements UpdateUserRoleService {
  @Override
  public void updateUserRole(User user) {
    FindRoleByPermissionsService findRoleByPermissionsService = BeanProvider.getBean(FindRoleByPermissionsService.class);
    Role userRole = findRoleByPermissionsService.findRoleByPermissions(user.getPermissions());

    if (userRole != null) {
      user.setRole(userRole);
    }
  }
}
