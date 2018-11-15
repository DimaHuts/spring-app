package notebook.service.permission.impl;

import notebook.entity.Permission;
import notebook.repository.PermissionRepository;
import notebook.service.common.BeanProvider;
import notebook.service.permission.PermissionService;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl implements PermissionService {
  @Override
  public Permission findPermissionByName(String name) {
    PermissionRepository permissionRepository = BeanProvider.getBean(PermissionRepository.class);

    return permissionRepository.findPermissionByName(name);
  }

  @Override
  public Permission save(Permission permission) {
    PermissionRepository permissionRepository = BeanProvider.getBean(PermissionRepository.class);

    return permissionRepository.save(permission);
  }
}
