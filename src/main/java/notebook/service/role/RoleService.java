package notebook.service.role;

import notebook.entity.Role;

public interface RoleService {
  Role findRoleByName(String name);

  void saveRole(Role role);
}
