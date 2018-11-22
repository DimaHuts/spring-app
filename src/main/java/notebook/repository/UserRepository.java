package notebook.repository;

import notebook.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
  @Query("select u from User u where u.email = :email")
  @EntityGraph(attributePaths = {"permissions"})
  User findByEmail(@Param("email") String email);

  @Query("select u from User u")
  @EntityGraph(attributePaths = {"permissions"})
  List<User> findAllUsers();

  @Query("select u.id from User u where u.email = :email")
  Integer findUserIdByEmail(@Param("email") String email);

  @Query("select u from User u where u.id = :id")
  User getUserById(@Param("id") long id);
}
