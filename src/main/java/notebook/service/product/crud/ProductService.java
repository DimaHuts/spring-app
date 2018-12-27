package notebook.service.product.crud;

import notebook.entity.Product;

public interface ProductService {
	Product saveProduct(Product product);

	long deleteProduct(Long id);
}
