package notebook.service.authentication.getsecurityuserauthorirties;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import notebook.entity.Permission;
import notebook.service.common.BeanProvider;
import notebook.service.permission.findpermissionsByIds.FindPermissionsByIdsService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import notebook.entity.User;

public interface SecurityUserAuthorities {
	static Collection<? extends GrantedAuthority> getSecurityUserAuthorities(User user) {
		List<Long> permissionsIds = user.getPermissions().stream().map(Permission::getId).collect(Collectors.toList());
		FindPermissionsByIdsService findPermissionsByIdsService = BeanProvider.getBean(FindPermissionsByIdsService.class);

		List<Permission> newUserPermissions = findPermissionsByIdsService.findPermissionsByInventoryIds(permissionsIds);

		List<GrantedAuthority> authorities = new ArrayList<>();
		newUserPermissions.stream()
			.map(permission -> new SimpleGrantedAuthority(permission.getName()))
			.forEach(authorities::add);

    return authorities;
	}
}
