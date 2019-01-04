package notebook.service.authentication.getsecurityuserauthorirties;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import notebook.entity.Permission;
import notebook.service.common.BeanProvider;
import notebook.service.permission.findallpermissions.FindAllPermissionsService;
import notebook.service.user.finduserbyemail.FindUserByEmailService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import notebook.entity.User;

public interface SecurityUserAuthorities {
	static Collection<? extends GrantedAuthority> getSecurityUserAuthorities(User user) {
		List<GrantedAuthority> authorities = new ArrayList<>();

		FindAllPermissionsService findAllPermissionsService = BeanProvider.getBean(FindAllPermissionsService.class);

		List<Permission> allPermissions = findAllPermissionsService.findAllPermissions();



		if (userFromDb != null) {
			userFromDb.getPermissions().stream()
				.map(permission -> new SimpleGrantedAuthority(permission.getName()))
				.forEach(authorities::add);
		}

    return authorities;
	}
}
