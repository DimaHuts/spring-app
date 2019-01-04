package notebook.service.authentication.updatesecuritycontext;

import java.util.Collection;

import notebook.service.common.BeanProvider;
import notebook.service.common.SecurityContextHandler;
import org.springframework.security.authentication.AuthenticationManager;
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
		Authentication newAuth = new UsernamePasswordAuthenticationToken(auth.getPrincipal(), null, updatedAuthorities);

		SecurityContextHandler.updateSecurityContext(newAuth);


	}
}
