package notebook.init;

import notebook.entity.Permission;
import notebook.service.common.BeanProvider;
import notebook.service.permission.PermissionService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {
  private boolean alreadySetup = false;

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    if (alreadySetup) {
      return;
    }

    Permission readPermission
      = createPermissionIfNotFound("VIEW_PRODUCTS");
    Permission writePermission
      = createPermissionIfNotFound("CREATE_EDIT_PRODUCTS");

//    List<Permission> adminPermissions = Arrays.asList(
//      readPermission, writePermission);
//    createRoleIfNotFound("ROLE_ADMIN", adminPermissions);
//    createRoleIfNotFound("ROLE_USER", Arrays.asList(readPermission));
//
//    Role adminRole = roleRepository.findByName("ROLE_ADMIN");
//    User user = new User();
//    user.setFirstName("Test");
//    user.setLastName("Test");
//    user.setPassword(passwordEncoder.encode("test"));
//    user.setEmail("test@test.com");
//    user.setRoles(Arrays.asList(adminRole));
//    user.setEnabled(true);
//    userRepository.save(user);

    alreadySetup = true;
  }

  @Transactional
  Permission createPermissionIfNotFound(String name) {
    PermissionService permissionService = BeanProvider.getBean(PermissionService.class);

    Permission permission = permissionService.findPermissionByName(name);

    if (permission == null) {
      permission = new Permission(name);
      permissionService.save(permission);
    }
    return permission;
  }
}
