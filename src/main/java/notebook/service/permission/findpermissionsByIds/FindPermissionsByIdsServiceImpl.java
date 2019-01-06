package notebook.service.permission.findpermissionsByIds;

import notebook.entity.Permission;
import notebook.repository.permission.FindPermissionsByIdsRepository;
import notebook.service.common.BeanProvider;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindPermissionsByIdsServiceImpl implements FindPermissionsByIdsService {
  @Override
  public List<Permission> findPermissionsByInventoryIds(List<Long> permissionsIds) {
    FindPermissionsByIdsRepository findPermissionsByIdsRepository = BeanProvider.getBean(FindPermissionsByIdsRepository.class);

    return findPermissionsByIdsRepository.findByIdIn(permissionsIds);
  }
}
