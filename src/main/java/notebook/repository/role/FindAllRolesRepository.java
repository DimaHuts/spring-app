package notebook.repository.role;

import notebook.entity.Role;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface FindAllRolesRepository extends JpaRepository<Role, Long> {
  @Query("select r from Role r")
  @EntityGraph(attributePaths = {"permissions"})
  Set<Role> findAllRoles();
}
