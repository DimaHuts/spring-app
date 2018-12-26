package notebook.init;

import notebook.entity.Permission;
import notebook.entity.Role;
import notebook.enums.Permissions;
import notebook.enums.Roles;
import notebook.service.common.BeanProvider;
import notebook.service.permission.crud.PermissionService;
import notebook.service.permission.findPermissionByName.FindPermissionByNameService;
import notebook.service.role.crud.RoleService;
import notebook.service.role.findRoleByName.FindRoleByNameService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Component
public class RolesAndPermissionsInitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {
  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    uploadInitialData();
  }

  private void uploadInitialData() {
    Permission viewAllProductsPermission = createPermissionIfNotFound(Permissions.VIEW_ALL_PRODUCTS.getPermission());
    Permission crudForProduct = createPermissionIfNotFound(Permissions.CREATE_EDIT_VIEW_PRODUCTS.getPermission());

    Set<Permission> userPermissions = new HashSet<>(Collections.singletonList(crudForProduct));
    Set<Permission> adminPermissions = new HashSet<>(Arrays.asList(crudForProduct, viewAllProductsPermission));

    Role userRole = new Role(Roles.USER.getRoleName(), userPermissions);
    Role  adminRole = new Role(Roles.ADMIN.getRoleName(), adminPermissions);

    createRoleIfNotFound(userRole);
    createRoleIfNotFound(adminRole);
  }

  @Transactional
  Permission createPermissionIfNotFound(String name) {
    FindPermissionByNameService findPermissionByNameService = BeanProvider.getBean(FindPermissionByNameService.class);
    Permission permission = findPermissionByNameService.findPermissionByName(name);

    if (permission == null) {
      permission = new Permission(name);

      PermissionService permissionService = BeanProvider.getBean(PermissionService.class);
      permissionService.save(permission);
    }

    return permission;
  }

  @Transactional
  void createRoleIfNotFound(Role role) {
    FindRoleByNameService findRoleByNameService = BeanProvider.getBean(FindRoleByNameService.class);
    Role roleFromDb = findRoleByNameService.findRoleByName(role.getName());

    if (roleFromDb == null) {
      RoleService roleService = BeanProvider.getBean(RoleService.class);

      roleService.saveRole(role);
    }
  }
}
