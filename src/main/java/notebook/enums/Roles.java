package notebook.enums;

public enum Roles {
  USER("USER_ROLE"),
  ADMIN("ADMIN_ROLE");

  private String roleName;

  Roles(String roleName) {
    this.roleName = roleName;
  }

  public String getRoleName() {
    return roleName;
  }
}
