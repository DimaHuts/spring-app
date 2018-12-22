package notebook.repository.user;

import notebook.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GetUserByIdRepository extends UserRepository {
  @Query("select u from User u where u.id = :id")
  @EntityGraph(attributePaths = {"permissions"})
  User getUserById(@Param("id") long id);
}
