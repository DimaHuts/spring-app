package notebook.service.permission.findPermissionByName;

import notebook.entity.Permission;

public interface FindPermissionByNameService {
  Permission findPermissionByName(String name);
}
