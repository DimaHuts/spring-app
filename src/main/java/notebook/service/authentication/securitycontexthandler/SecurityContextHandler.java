package notebook.service.authentication.securitycontexthandler;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityContextHandler {
  private Authentication authentication;

  public SecurityContextHandler(Authentication authentication) {
    this.authentication = authentication;
  }

  public void setSecurityContext() {
    SecurityContextHolder.getContext().setAuthentication(this.authentication);
  }
}
