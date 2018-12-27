package notebook.service.product.firstconfigureproduct;

import notebook.entity.Product;
import notebook.entity.User;
import notebook.service.common.BeanProvider;
import notebook.service.common.ContextManagerInterface;
import org.springframework.stereotype.Service;

@Service
public class FirstConfigureProductServiceImpl implements FirstConfigureProductService {
  @Override
  public void configureProduct(Product product) {
    ContextManagerInterface contextManager = BeanProvider.getBean(ContextManagerInterface.class);

    User currentUser = contextManager.getUserFromContext();

    product.setUser(currentUser);
  }
}
