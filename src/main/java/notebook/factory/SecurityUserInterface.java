package notebook.factory;

import notebook.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public interface SecurityUserInterface {
  UserDetails getConfiguredSecurityUser(User user);

  Collection<? extends GrantedAuthority> getSecurityUserAuthority(User user);
}
