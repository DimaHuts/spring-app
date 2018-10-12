package notebook.service.common;

import notebook.factory.ApplicationContextFactory;

public interface BeanProvider {

  static <T> T getBean(Class<T> beanName) {
    var context = new ApplicationContextFactory().getApplicationContext();

    return context.getBean(beanName);
  }
}
