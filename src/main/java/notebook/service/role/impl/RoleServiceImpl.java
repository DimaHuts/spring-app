package notebook.service.role.impl;

import notebook.entity.Role;
import notebook.repository.RoleRepository;
import notebook.service.common.BeanProvider;
import notebook.service.role.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
  @Override
  public Role findRoleByName(String name) {
    RoleRepository roleRepository = BeanProvider.getBean(RoleRepository.class);

    return roleRepository.findRoleByName(name);
  }

  @Override
  public void saveRole(Role role) {
    RoleRepository roleRepository = BeanProvider.getBean(RoleRepository.class);

    roleRepository.save(role);
  }
}
