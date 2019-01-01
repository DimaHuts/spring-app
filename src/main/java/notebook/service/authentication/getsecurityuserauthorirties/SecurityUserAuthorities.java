package notebook.service.authentication.getsecurityuserauthorirties;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import notebook.entity.User;

public interface SecurityUserAuthorities {
	static Collection<? extends GrantedAuthority> getSecurityUserAuthorities(User user) {
		List<GrantedAuthority> authorities = new ArrayList<>();

    user.getPermissions().stream()
      .map(permission -> new SimpleGrantedAuthority(permission.getName()))
      .forEach(authorities::add);

    return authorities;
	}
}
