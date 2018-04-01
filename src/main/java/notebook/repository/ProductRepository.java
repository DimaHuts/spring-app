package notebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import notebook.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
