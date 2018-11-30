package notebook.init;

import notebook.entity.Permission;
import notebook.enums.Permissions;
import notebook.service.common.BeanProvider;
import notebook.service.permission.PermissionService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Component
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {
  private boolean alreadySetup = false;

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    if (alreadySetup) {
      return;
    }

    Permission viewAllProductsPermission = createPermissionIfNotFound(Permissions.VIEW_ALL_PRODUCTS.getPermission());
    Permission crudForProduct = createPermissionIfNotFound(Permissions.CREATE_EDIT_VIEW_PRODUCTS.getPermission());

    Set<Permission> userPermissions = new HashSet<>(Collections.singletonList(crudForProduct));
    Set<Permission> adminPermissions = new HashSet<>(Arrays.asList(crudForProduct, viewAllProductsPermission));
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
