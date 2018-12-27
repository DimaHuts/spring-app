package notebook.service.product.crud;

import notebook.service.common.BeanProvider;
import org.springframework.stereotype.Service;

import notebook.entity.Product;
import notebook.repository.product.CrudProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
  public Product saveProduct(Product product) {
    CrudProductRepository productRepository = BeanProvider.getBean(CrudProductRepository.class);

    return productRepository.save(product);
  }

  public long deleteProduct(Long id) {
  	CrudProductRepository productRepository = BeanProvider.getBean(CrudProductRepository.class);
    productRepository.deleteById(id);

    return id;
  }
}
