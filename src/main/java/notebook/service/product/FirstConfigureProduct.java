package notebook.service.product;

import notebook.entity.Product;
import notebook.entity.User;
import notebook.service.common.ContextManagerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class FirstConfigureProduct implements FirstConfigureProductInterface {

  private final ApplicationContext context;

  @Autowired
  public FirstConfigureProduct(ApplicationContext context) {
    this.context = context;
  }

  @Override
  public void configureProduct(Product product) {
    User currentUser = context.getBean(ContextManagerInterface.class).getUserFromContext();

    product.setId(currentUser.getId());
  }
}
