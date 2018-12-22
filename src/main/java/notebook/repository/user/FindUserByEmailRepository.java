package notebook.repository.user;

import notebook.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FindUserByEmailRepository extends JpaRepository<User, Long> {
  @Query("select u from User u where u.email = :email")
  @EntityGraph(attributePaths = {"permissions"})
  User findByEmail(@Param("email") String email);
}
