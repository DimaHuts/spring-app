package notebook.factory;

import notebook.entity.User;
import notebook.service.authentication.getsecurityuserauthorirties.SecurityUserAuthorities;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collection;

public class AuthenticationFactory {
  public Authentication getAuthenticationObject(String username, String password) {
    return new UsernamePasswordAuthenticationToken(username, password);
  }

  public Authentication getAuthenticationObject(User userForUpdate) {
    Collection<? extends GrantedAuthority> updatedAuthorities = SecurityUserAuthorities.getSecurityUserAuthorities(userForUpdate);
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();

    return new UsernamePasswordAuthenticationToken(auth.getPrincipal(), null, updatedAuthorities);
  }
}
