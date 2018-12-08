package notebook.repository;

import notebook.entity.Permission;
import notebook.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface RoleRepository extends JpaRepository<Role, Long> {

  @Query("select r from Role r where r.name = :name")
  Role findRoleByName(@Param("name") String name);

  @Query("select r from Role r where r.permissions = :permissions")
  Role findRoleByPermissions(@Param("permissions") Set<Permission> permissions);
}
