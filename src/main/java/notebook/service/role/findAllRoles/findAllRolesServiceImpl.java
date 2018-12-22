package notebook.service.role.findAllRoles;

import notebook.entity.Role;
import notebook.repository.role.FindAllRolesRepository;
import notebook.service.common.BeanProvider;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class findAllRolesServiceImpl implements FindAllRolesService {
  @Override
  public Set<Role> findAllRoles() {
    FindAllRolesRepository findAllRolesRepository = BeanProvider.getBean(FindAllRolesRepository.class);

    return findAllRolesRepository.findAllRoles();
  }
}
