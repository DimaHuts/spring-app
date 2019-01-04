package notebook.service.permission.findallpermissions;

import notebook.entity.Permission;
import notebook.repository.permission.FindAllPermissionsRepository;
import notebook.service.common.BeanProvider;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllPermissionsServiceImpl implements FindAllPermissionsService {
  @Override
  public List<Permission> findAllPermissions() {
    FindAllPermissionsRepository findAllPermissionsRepository = BeanProvider.getBean(FindAllPermissionsRepository.class);

    return findAllPermissionsRepository.findAllPermissions();
  }
}
