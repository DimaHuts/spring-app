package notebook.service.permission.crud;

import notebook.entity.Permission;
import notebook.repository.permission.CrudPermissionRepository;
import notebook.service.common.BeanProvider;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl implements PermissionService {
  @Override
  public Permission save(Permission permission) {
    CrudPermissionRepository permissionRepository = BeanProvider.getBean(CrudPermissionRepository.class);

    return permissionRepository.save(permission);
  }
}
