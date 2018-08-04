package notebook.aop;

import notebook.entity.Product;
import notebook.service.product.FirstConfigureProduct;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ProductConfigurer {

  private final ApplicationContext context;

  @Autowired
  public ProductConfigurer(ApplicationContext context) {
    this.context = context;
  }

  @Before("execution(* notebook.controller.ProductController.createProduct(..)) && args(product)")
  public void configureProductBeforeCreating(Product product) {
    context
      .getBean(FirstConfigureProduct.class)
      .configureProduct(product);
  }
}
