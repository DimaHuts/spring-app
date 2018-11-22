package notebook.dto;

import notebook.entity.Permission;

import java.util.Set;

public class UserDto {
  private long id;

  private String email;

  private String firstName;

  private String lastName;

  private byte roleId;

  private Set<Permission> permissions;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
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

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
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
