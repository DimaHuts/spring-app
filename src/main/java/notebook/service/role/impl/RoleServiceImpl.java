package notebook.service.role.impl;

import notebook.entity.Permission;
import notebook.entity.Role;
import notebook.repository.RoleRepository;
import notebook.service.common.BeanProvider;
import notebook.service.role.RoleService;
import notebook.service.role.CompareTwoSetsPermissions;
import org.springframework.stereotype.Service;

import java.util.Set;

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

  @Override
  public Role findRoleByPermissions(Set<Permission> permissions) {
    RoleRepository roleRepository = BeanProvider.getBean(RoleRepository.class);

    Set<Role> allRoles = roleRepository.findAllRoles();

    Role existedUserRole = null;
    CompareTwoSetsPermissions twoSetsPermissionsComparator = new CompareTwoSetsPermissionsImpl();

    for (Role role : allRoles) {
      if (twoSetsPermissionsComparator.compare(role.getPermissions(), permissions)) {
        existedUserRole = role;
      }
    }

    return existedUserRole;
  }
}
