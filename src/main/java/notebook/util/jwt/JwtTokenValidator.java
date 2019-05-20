package notebook.util.jwt;

import io.jsonwebtoken.*;
import notebook.property.JWTProperties;
import notebook.service.common.BeanProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenValidator {

  private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);

  public boolean validateToken(String authToken) {
    JWTProperties jwtProperties = BeanProvider.getBean(JWTProperties.class);

    String jwtSecret = jwtProperties.getSecret();

    try {
      Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
      return true;
    } catch (SignatureException ex) {
      logger.error("Invalid JWT signature");
    } catch (MalformedJwtException ex) {
      logger.error("Invalid JWT token");
    } catch (ExpiredJwtException ex) {
      logger.error("Expired JWT token");
    } catch (UnsupportedJwtException ex) {
      logger.error("Unsupported JWT token");
    } catch (IllegalArgumentException ex) {
      logger.error("JWT claims string is empty.");
    }
    return false;
  }
}
