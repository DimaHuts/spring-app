package notebook.service.permission.findpermissionsByIds;

import notebook.entity.Permission;

import java.util.List;

public interface FindPermissionsByIdsService {
  List<Permission> findPermissionsByInventoryIds(List<Long> permissionsIds);
}
