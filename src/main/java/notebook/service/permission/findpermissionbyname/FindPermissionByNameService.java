package notebook.service.permission.findpermissionbyname;

import notebook.entity.Permission;

public interface FindPermissionByNameService {
  Permission findPermissionByName(String name);
}
