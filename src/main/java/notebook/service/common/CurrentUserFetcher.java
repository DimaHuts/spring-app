package notebook.service.common;

import notebook.entity.User;

public interface CurrentUserFetcher {

  static User getCurrentUser() {
    var contextManager = BeanProvider.getBean(ContextManagerInterface.class);
    return contextManager.getUserFromContext();
  }
}
