package notebook.service.common;

import notebook.factory.ApplicationContextFactory;
import org.springframework.context.ApplicationContext;

public interface BeanProvider {

  static <T> T getBean(Class<T> beanName) {
    ApplicationContext context = new ApplicationContextFactory().getApplicationContext();

    return context.getBean(beanName);
  }
}
