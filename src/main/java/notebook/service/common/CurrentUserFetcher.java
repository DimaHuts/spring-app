package notebook.service.common;

import notebook.entity.User;

public interface CurrentUserFetcher {

  static User getCurrentUser() {
    ContextManagerInterface contextManager = BeanProvider.getBean(ContextManagerInterface.class);
    return contextManager.getUserFromContext();
  }
}
