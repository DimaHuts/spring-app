package notebook.aop;

import notebook.entity.Product;
import notebook.entity.User;
import notebook.service.common.CurrentUserFetcher;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ProductConfigurer {

  @Before("execution(* notebook.controller.ProductController.createProduct(..)) && args(product)")
  public void configureProductBeforeCreating(Product product) {
    User currentUser = CurrentUserFetcher.getCurrentUser();
    product.setUser(currentUser);
  }

  @Before("execution(* notebook.controller.ProductController.updateProduct(..)) && args(product)")
  public void configureProductBeforeUpdating(Product product) {
    User currentUser = CurrentUserFetcher.getCurrentUser();
    product.setUser(currentUser);
  }
}
