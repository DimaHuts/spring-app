package notebook.repository.product;

import notebook.entity.Product;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FindProductsByUserRepository extends ProductRepository {
  @EntityGraph(attributePaths = {"categories"})
  @Query("select p from Product p where p.user.id = :userId")
  List<Product> findProductsByUser(@Param("userId") long userId);
}
