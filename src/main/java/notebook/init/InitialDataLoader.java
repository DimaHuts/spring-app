package notebook.init;

import notebook.entity.Permission;
import notebook.enums.Permissions;
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

    createPermissionIfNotFound(Permissions.VIEW_ALL_PRODUCTS.getPermission());
    createPermissionIfNotFound(Permissions.CREATE_EDIT_VIEW_PRODUCTS.getPermission());

    alreadySetup = true;
  }

  @Transactional
  void createPermissionIfNotFound(String name) {
    PermissionService permissionService = BeanProvider.getBean(PermissionService.class);

    Permission permission = permissionService.findPermissionByName(name);

    if (permission == null) {
      permission = new Permission(name);
      permissionService.save(permission);
    }
  }
}
