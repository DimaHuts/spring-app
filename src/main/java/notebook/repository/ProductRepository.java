package notebook.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import notebook.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
  @EntityGraph(attributePaths = {"categories"})
  @Query("select p from Product p")
  List<Product> findAllProducts();

  @Query("select p from Product p where p.userId = :userId")
  List<Product> findProductsByUser(@Param("userId") long userId);
}
