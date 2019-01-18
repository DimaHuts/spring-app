package notebook.service.authentication.updatesecuritycontext;

import notebook.factory.AuthenticationFactory;
import notebook.service.common.SecurityContextHandler;
import org.springframework.security.core.Authentication;

import notebook.entity.User;

public interface SecurityContextService {
	static void updateAuthorities(User userForUpdate) {
		AuthenticationFactory authenticationFactory = new AuthenticationFactory();
		Authentication authentication = authenticationFactory.getAuthenticationObject(userForUpdate);

		SecurityContextHandler.setAuthentication(authentication);
	}
}
