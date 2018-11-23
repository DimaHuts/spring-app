package notebook.service.product;

import notebook.entity.Product;
import notebook.entity.User;
import notebook.service.common.BeanProvider;
import notebook.service.common.ContextManagerInterface;
import org.springframework.stereotype.Service;

@Service
public class FirstConfigureProduct implements FirstConfigureProductInterface {
  @Override
  public void configureProduct(Product product) {
    ContextManagerInterface contextManager = BeanProvider.getBean(ContextManagerInterface.class);

    User currentUser = contextManager.getUserFromContext();

    product.setUser(currentUser);
  }
}
