package notebook.repository.permission;

import notebook.entity.Permission;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FindAllPermissionsRepository extends PermissionRepository {
  @Query("select p from Permission p")
  List<Permission> findAllPermissions();
}
