package notebook.repository;

import notebook.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  User findByEmail(String email);
  User findById(int id);

  @Query("select u from User u")
  List<User> findAllUsers();

  @Query("select u.id from User u where u.email = :email")
  Integer findUserIdByEmail(@Param("email") String email);
}
