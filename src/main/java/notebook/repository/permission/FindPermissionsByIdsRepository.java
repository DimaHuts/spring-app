package notebook.repository.permission;

import notebook.entity.Permission;

import java.util.List;

public interface FindPermissionsByIdsRepository extends PermissionRepository {
  List<Permission> findByIdIn(List<Long> ids);
}
