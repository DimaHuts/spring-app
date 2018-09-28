package notebook.service.common;

import notebook.factory.ApplicationContextFactory;
import notebook.service.authentication.AuthenticationManagerInterface;

public interface BeanProvider {

  static <T> T getBean(Class<T> beanName) {
    var context = new ApplicationContextFactory().getApplicationContext();

    return (T)context.getBean(beanName);
  }
}
