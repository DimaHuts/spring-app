package notebook.service.product.findallproducts;

import notebook.entity.Product;
import notebook.repository.product.FindAllProductsRepository;
import notebook.service.common.BeanProvider;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllProductsServiceImpl implements FindAllProductsService {
  @Override
  public List<Product> findAll() {
    FindAllProductsRepository findAllProductsRepository = BeanProvider.getBean(FindAllProductsRepository.class);

    return findAllProductsRepository.findAllProducts();
  }
}
