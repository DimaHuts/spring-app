package notebook.enums;

public enum DefaultRoles {
    USER(new byte[1]);

    DefaultRoles(byte[] roles) {
        this.roles = roles;
    }

    private byte[] roles;

    public byte[] getRoles() {
        return roles;
    }

    public void setRole(byte[] role) {
        this.roles = role;
    }
}
