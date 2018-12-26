package notebook.repository.permission;

import notebook.entity.Permission;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FindPermissionByNameRepository extends PermissionRepository {
  @Query("select p from Permission p where p.name = :name")
  Permission findPermissionByName(@Param("name") String name);
}
