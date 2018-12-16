package notebook.service.role;

import notebook.entity.Permission;

import java.util.Set;

public interface CompareTwoSetsPermissions {
  boolean compare(Set<Permission> firstSet, Set<Permission> secondSet);
}
