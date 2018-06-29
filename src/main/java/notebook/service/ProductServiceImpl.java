package notebook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import notebook.entity.Product;
import notebook.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;

	@Autowired
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public List<Product> findAll() {
		return productRepository.findAllProducts();
	}

	public Product saveProduct(Product product) {
		productRepository.save(product);

		return product;
	}

	public long deleteProduct(Long id) {
		productRepository.deleteById(id);

		return id;
	}

}
