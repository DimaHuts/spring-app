package notebook.service.role.impl;

import notebook.entity.Permission;
import notebook.service.role.CompareTwoSetsPermissions;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CompareTwoSetsPermissionsImpl implements CompareTwoSetsPermissions {
  @Override
  public boolean compare(Set<Permission> firstSet, Set<Permission> secondSet) {
    if (isNullOneOfSetsPermissions(firstSet, secondSet)) {
      return false;
    }

    List<Long> firstSetIds = transformSetPermissionsToListIds(firstSet);
    List<Long> secondSetIds = transformSetPermissionsToListIds(secondSet);

    boolean isEqualSizesOfSets = firstSetIds.size() == secondSetIds.size();
    boolean isFirstSetIdsContainsSecondSetIds = firstSetIds.containsAll(secondSetIds);

    return isEqualSizesOfSets && isFirstSetIdsContainsSecondSetIds;
  }

  private boolean isNullOneOfSetsPermissions(Set<Permission> firstSet, Set<Permission> secondSet) {
    return firstSet == null || secondSet == null;
  }

  private List<Long> transformSetPermissionsToListIds(Set<Permission> setPermissions) {
    return setPermissions.stream().map(Permission::getId).collect(Collectors.toList());
  }
}
