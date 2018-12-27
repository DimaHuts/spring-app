package notebook.repository.product;

import notebook.entity.Product;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FindAllProductsRepository extends ProductRepository {
  @EntityGraph(attributePaths = {"categories"})
  @Query("select p from Product p")
  List<Product> findAllProducts();
}
