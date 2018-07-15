package notebook.enums;

public enum Security {
  SECRET("SecretKeyToGenJWTs"),
  EXPIRATION_TIME("864_000_000"), // 10 days
  TOKEN_PREFIX("Bearer "),
  HEADER_STRING("Authorization"),
  SIGN_UP_URL("/users/sign-up");

  private String value;

  Security(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
