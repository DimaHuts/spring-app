package notebook.repository.user;

import notebook.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FindAllUsersRepository extends JpaRepository<User, Long> {
  @Query("select u from User u")
  @EntityGraph(attributePaths = {"permissions"})
  List<User> findAllUsers();
}
