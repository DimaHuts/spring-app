package notebook.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(unique = true)
  private String email;

  private String password;

  private String firstName;

  private String lastName;

  private byte roleId;

  @ManyToMany(
    fetch = FetchType.LAZY,
    cascade = {
      CascadeType.REFRESH,
    })
  @JoinTable(
    name = "users_permissions",
    joinColumns = { @JoinColumn(name = "userId") },
    inverseJoinColumns = { @JoinColumn(name = "permissionId") }
  )
  private Set<Permission> permissions;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public byte getRoleId() {
    return roleId;
  }

  public void setRoleId(byte roleId) {
    this.roleId = roleId;
  }

  public Set<Permission> getPermissions() {
    return permissions;
  }

  public void setPermissions(Set<Permission> permissions) {
    this.permissions = permissions;
  }
}
