package notebook.service.role.crud;

import notebook.entity.Role;
import notebook.repository.role.RoleRepository;
import notebook.service.common.BeanProvider;
import notebook.service.role.crud.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
  @Override
  public void saveRole(Role role) {
    RoleRepository roleRepository = BeanProvider.getBean(RoleRepository.class);

    roleRepository.save(role);
  }
}
