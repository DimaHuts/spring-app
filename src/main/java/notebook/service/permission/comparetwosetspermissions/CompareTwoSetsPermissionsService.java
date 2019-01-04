package notebook.service.permission.comparetwosetspermissions;

import notebook.entity.Permission;

import java.util.Set;

public interface CompareTwoSetsPermissionsService {
  boolean compare(Set<Permission> firstSet, Set<Permission> secondSet);
}
