package notebook.service.role.findrolebypermissions;

import notebook.entity.Permission;
import notebook.entity.Role;
import notebook.service.common.BeanProvider;
import notebook.service.role.comparetwosetspermissions.CompareTwoSetsPermissionsService;
import notebook.service.role.findallroles.FindAllRolesService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class FindRoleByPermissionsServiceImpl implements FindRoleByPermissionsService {
  @Override
  public Role findRoleByPermissions(Set<Permission> permissions) {
    FindAllRolesService findAllRolesService = BeanProvider.getBean(FindAllRolesService.class);

      Set<Role> allRoles = findAllRolesService.findAllRoles();

      Role existedUserRole = null;
      CompareTwoSetsPermissionsService twoSetsPermissionsComparator = BeanProvider.getBean(CompareTwoSetsPermissionsService.class);

      for (Role role : allRoles) {
        if (twoSetsPermissionsComparator.compare(role.getPermissions(), permissions)) {
          existedUserRole = role;
        }
      }

      return existedUserRole;
  }
}
