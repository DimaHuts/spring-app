package notebook.service.product;

import java.util.List;

import notebook.entity.User;
import notebook.service.common.BeanProvider;
import notebook.service.common.CurrentUserFetcher;
import org.springframework.stereotype.Service;

import notebook.entity.Product;
import notebook.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	public List<Product> findAll() {
		ProductRepository productRepository = BeanProvider.getBean(ProductRepository.class);
		return productRepository.findAllProducts();
	}

	public Product saveProduct(Product product) {
		ProductRepository productRepository = BeanProvider.getBean(ProductRepository.class);

		return productRepository.save(product);
	}

	public long deleteProduct(Long id) {
		ProductRepository productRepository = BeanProvider.getBean(ProductRepository.class);
    productRepository.deleteById(id);

		return id;
	}

	@Override
	public List<Product> getProductsByUser(long userId) {
		ProductRepository productRepository = BeanProvider.getBean(ProductRepository.class);
    return productRepository.findProductsByUser(userId);
	}

	public long getUserIdForFetchProduct(long userIdFromRequest) {
		User authenticatedUser = CurrentUserFetcher.getCurrentUser();
		long resultUserId = authenticatedUser.getId();

		if (userIdFromRequest != 0) {
			resultUserId = userIdFromRequest;
		}

		return resultUserId;
	}

}
