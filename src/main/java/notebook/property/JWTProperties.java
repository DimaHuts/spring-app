package notebook.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "jwt")
public class JWTProperties {
  private String secret;

  private Long expirationInMs;

  public void setSecret(String secret) {
    this.secret = secret;
  }

  public void setExpirationInMs(Long expirationInMs) {
    this.expirationInMs = expirationInMs;
  }

  public String getSecret() {
    return secret;
  }

  public Long getExpirationInMs() {
    return expirationInMs;
  }
}
