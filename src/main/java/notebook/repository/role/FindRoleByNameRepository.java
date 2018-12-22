package notebook.repository.role;

import notebook.entity.Role;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FindRoleByNameRepository extends JpaRepository<Role, Long> {
  @Query("select r from Role r where r.name = :name")
  @EntityGraph(attributePaths = {"permissions"})
  Role findRoleByName(@Param("name") String name);
}
