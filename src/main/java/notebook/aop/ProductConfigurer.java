package notebook.aop;

import notebook.entity.Product;
import notebook.service.common.BeanProvider;
import notebook.service.product.FirstConfigureProductInterface;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ProductConfigurer {

  @Before("execution(* notebook.controller.ProductController.createProduct(..)) && args(product)")
  public void configureProductBeforeCreating(Product product) {
    FirstConfigureProductInterface firstConfigureProduct = BeanProvider.getBean(FirstConfigureProductInterface.class);

    firstConfigureProduct.configureProduct(product);
  }
}
