package notebook.repository;

import notebook.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PermissionRepository extends JpaRepository<Permission, Long> {

  @Query("select p from Permission p where p.name = :name")
  Permission findPermissionByName(@Param("name") String name);
}
