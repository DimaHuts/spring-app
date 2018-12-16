package notebook.service.role;

import notebook.entity.Permission;
import notebook.entity.Role;

import java.util.Set;

public interface RoleService {
  Role findRoleByName(String name);

  void saveRole(Role role);

  Role findRoleByPermissions(Set<Permission> permissions);
}
