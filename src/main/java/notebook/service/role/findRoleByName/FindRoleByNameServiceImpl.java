package notebook.service.role.findRoleByName;

import notebook.entity.Role;
import notebook.repository.role.FindRoleByNameRepository;
import notebook.service.common.BeanProvider;
import org.springframework.stereotype.Service;

@Service
public class FindRoleByNameServiceImpl implements FindRoleByNameService {
  @Override
  public Role findRoleByName(String name) {
    FindRoleByNameRepository findRoleByNameRepository = BeanProvider.getBean(FindRoleByNameRepository.class);

    return findRoleByNameRepository.findRoleByName(name);
  }
}
