package notebook.service.authentication.updatesecuritycontext;

import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import notebook.entity.User;
import notebook.service.authentication.getsecurityuserauthorirties.SecurityUserAuthorities;

public interface SecurityContextService {
	static void updateAuthorities(User userForUpdate) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		Collection<? extends GrantedAuthority> updatedAuthorities = SecurityUserAuthorities.getSecurityUserAuthorities(userForUpdate);
		Authentication newAuth = new UsernamePasswordAuthenticationToken(auth.getPrincipal(), auth.getCredentials(), updatedAuthorities);

		SecurityContextHolder.getContext().setAuthentication(newAuth);
	}
}
