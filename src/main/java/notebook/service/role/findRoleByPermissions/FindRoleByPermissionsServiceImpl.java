package notebook.service.role.findRoleByPermissions;

import notebook.entity.Permission;
import notebook.entity.Role;
import notebook.service.common.BeanProvider;
import notebook.service.role.CompareTwoSetsPermissions;
import notebook.service.role.findAllRoles.FindAllRolesService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class FindRoleByPermissionsServiceImpl implements FindRoleByPermissionsService {
  @Override
  public Role findRoleByPermissions(Set<Permission> permissions) {
    FindAllRolesService findAllRolesService = BeanProvider.getBean(FindAllRolesService.class);

      Set<Role> allRoles = findAllRolesService.findAllRoles();

      Role existedUserRole = null;
      CompareTwoSetsPermissions twoSetsPermissionsComparator = BeanProvider.getBean(CompareTwoSetsPermissions.class);

      for (Role role : allRoles) {
        if (twoSetsPermissionsComparator.compare(role.getPermissions(), permissions)) {
          existedUserRole = role;
        }
      }

      return existedUserRole;
  }
}
