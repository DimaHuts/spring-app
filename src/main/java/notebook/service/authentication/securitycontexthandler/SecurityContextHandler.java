package notebook.service.authentication.securitycontexthandler;

import org.springframework.security.core.Authentication;

public class SecurityContextHandler {
  private Authentication authentication;

  public SecurityContextHandler(Authentication authentication) {
    this.authentication = authentication;
  }

  public void setSecurityContext() {
    notebook.service.common.SecurityContextHandler.setAuthentication(this.authentication);
  }
}
