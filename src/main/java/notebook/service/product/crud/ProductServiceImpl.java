package notebook.service.product.crud;

import notebook.service.common.BeanProvider;
import org.springframework.stereotype.Service;

import notebook.entity.Product;
import notebook.repository.product.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
  public Product saveProduct(Product product) {
    ProductRepository productRepository = BeanProvider.getBean(ProductRepository.class);

    return productRepository.save(product);
  }

  public long deleteProduct(Long id) {
    ProductRepository productRepository = BeanProvider.getBean(ProductRepository.class);
    productRepository.deleteById(id);

    return id;
  }
}
