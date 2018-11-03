package notebook.service.product;

import java.util.List;

import notebook.entity.Product;

public interface ProductService {
	List<Product> findAll();

	Product saveProduct(Product product);

	long deleteProduct(Long id);

	List<Product> getProductsByUser(long userId);

	long getUserIdForFetchProduct(long userIdFromRequest);
}
