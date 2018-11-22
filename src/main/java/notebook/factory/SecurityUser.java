package notebook.factory;

import notebook.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class SecurityUser implements SecurityUserInterface {
  @Override
  public UserDetails getConfiguredSecurityUser(User user) {
    return new org.springframework.security.core.userdetails.User(
            user.getEmail(), user.getPassword(), getSecurityUserAuthority(user));
  }

  @Override
  public Collection<? extends GrantedAuthority> getSecurityUserAuthority(User user) {
    ArrayList<GrantedAuthority> authorities = new ArrayList<>();

    user.getPermissions().stream()
      .map(permission -> new SimpleGrantedAuthority(permission.getName()))
      .forEach(authorities::add);

    return authorities;
  }
}
