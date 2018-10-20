package notebook.service.product;

import java.util.List;

import notebook.service.common.BeanProvider;
import notebook.service.common.CurrentUserFetcher;
import org.springframework.stereotype.Service;

import notebook.entity.Product;
import notebook.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	public List<Product> findAll() {
		var productRepository = BeanProvider.getBean(ProductRepository.class);
		return productRepository.findAllProducts();
	}

	public Product saveProduct(Product product) {
    var productRepository = BeanProvider.getBean(ProductRepository.class);
    productRepository.save(product);

		return product;
	}

	public long deleteProduct(Long id) {
    var productRepository = BeanProvider.getBean(ProductRepository.class);
    productRepository.deleteById(id);

		return id;
	}

	@Override
	public List<Product> getProductsByUser(long userId) {
    var productRepository = BeanProvider.getBean(ProductRepository.class);
    return productRepository.findProductsByUser(userId);
	}

	public long getUserIdForFetchProduct(long userIdFromRequest) {
		var authenticatedUser = CurrentUserFetcher.getCurrentUser();
		var resultUserId = authenticatedUser.getId();

		if (userIdFromRequest != 0) {
			resultUserId = userIdFromRequest;
		}

		return resultUserId;
	}

}
