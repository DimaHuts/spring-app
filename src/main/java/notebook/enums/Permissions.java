package notebook.enums;

public enum Permissions {
  VIEW_ALL_PRODUCTS("VIEW_ALL_PRODUCTS"),
  CREATE_EDIT_VIEW_PRODUCTS("CREATE_EDIT_VIEW_PRODUCTS");

  private String permission;

  Permissions(String permission) {
    this.permission = permission;
  }

  public String getPermission() {
    return permission;
  }

  public void setPermission(String permission) {
    this.permission = permission;
  }
}
