package notebook.service.role.crud;

import notebook.entity.Role;
import notebook.repository.role.CrudRoleRepository;
import notebook.service.common.BeanProvider;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
  @Override
  public void saveRole(Role role) {
    CrudRoleRepository roleRepository = BeanProvider.getBean(CrudRoleRepository.class);

    roleRepository.save(role);
  }
}
