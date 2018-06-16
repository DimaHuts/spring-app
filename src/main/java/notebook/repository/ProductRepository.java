package notebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import notebook.entity.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p")
    List<Product> findAllProducts();

}
