package notebook.service.common;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public interface SecurityContextHandler {
  static void setAuthentication(Authentication authObj) {
    SecurityContextHolder.getContext().setAuthentication(authObj);
  }
}

