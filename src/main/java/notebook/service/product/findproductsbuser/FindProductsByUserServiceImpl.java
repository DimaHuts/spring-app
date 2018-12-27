package notebook.service.product.findproductsbuser;

import notebook.entity.Product;
import notebook.repository.product.FindProductsByUserRepository;
import notebook.service.common.BeanProvider;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindProductsByUserServiceImpl implements FindProductsByUserService {
  @Override
  public List<Product> getProductsByUser(long userId) {
    FindProductsByUserRepository findProductsByUserRepository = BeanProvider.getBean(FindProductsByUserRepository.class);

    return findProductsByUserRepository.findProductsByUser(userId);
  }
}
