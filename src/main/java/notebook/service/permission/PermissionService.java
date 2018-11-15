package notebook.service.permission;

import notebook.entity.Permission;

public interface PermissionService {
  Permission findPermissionByName(String name);

  Permission save(Permission permission);
}
