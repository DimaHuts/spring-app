package notebook.service.permission.findPermissionByName;

import notebook.entity.Permission;
import notebook.repository.permission.FindPermissionByNameRepository;
import notebook.service.common.BeanProvider;
import org.springframework.stereotype.Service;

@Service
public class findPermissionByNameServiceImpl implements FindPermissionByNameService {
  @Override
  public Permission findPermissionByName(String name) {
    FindPermissionByNameRepository findPermissionByNameRepository = BeanProvider.getBean(FindPermissionByNameRepository.class);

    return findPermissionByNameRepository.findPermissionByName(name);
  }
}
