package notebook.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Role {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  private String name;

  @ManyToMany(
          fetch = FetchType.LAZY,
          cascade = {
                  CascadeType.REFRESH,
          })
  @JoinTable(
          name = "roles_permissions",
          joinColumns = { @JoinColumn(name = "roleId") },
          inverseJoinColumns = { @JoinColumn(name = "permissionId") }
  )
  private Set<Permission> permissions;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<Permission> getPermissions() {
      return permissions;
  }

  public void setPermissions(Set<Permission> permissions) {
      this.permissions = permissions;
  }
}
