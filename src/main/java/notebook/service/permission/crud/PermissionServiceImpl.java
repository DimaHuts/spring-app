package notebook.service.permission.crud;

import notebook.entity.Permission;
import notebook.repository.PermissionRepository;
import notebook.service.common.BeanProvider;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl implements PermissionService {
  @Override
  public Permission save(Permission permission) {
    PermissionRepository permissionRepository = BeanProvider.getBean(PermissionRepository.class);

    return permissionRepository.save(permission);
  }
}
