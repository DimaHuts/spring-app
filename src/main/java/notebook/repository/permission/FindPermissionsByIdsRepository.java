package notebook.repository.permission;

import notebook.entity.Permission;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FindPermissionsByIdsRepository extends PermissionRepository {
  @Query("select p from Permission p where inventoryId in :ids")
  List<Permission> findPermissionsByInventoryIds(@Param("ids") List<Long> permissionsIds);

  List<Permission> findByIdIn(List<Long> ids);
}
