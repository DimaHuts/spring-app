package notebook.util.jwt;

import io.jsonwebtoken.*;
import notebook.property.JWTProperties;
import notebook.service.common.BeanProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {

//  private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);

  public String generateToken(Authentication authentication) {
    String userPrincipal = (String) authentication.getPrincipal();

    JWTProperties jwtProperties = BeanProvider.getBean(JWTProperties.class);
    long jwtExpirationInMs = jwtProperties.getExpirationInMs();

    Date now = new Date();
    Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);

    String jwtSecret = jwtProperties.getSecret();

    return Jwts.builder()
      .setSubject(userPrincipal)
      .setIssuedAt(new Date())
      .setExpiration(expiryDate)
      .signWith(SignatureAlgorithm.HS512, jwtSecret)
      .compact();
  }

  public String getUserIdFromJWT(String token) {
    JWTProperties jwtProperties = BeanProvider.getBean(JWTProperties.class);

    String jwtSecret = jwtProperties.getSecret();

    Claims claims = Jwts.parser()
      .setSigningKey(jwtSecret)
      .parseClaimsJws(token)
      .getBody();

    return claims.getSubject();
  }

//  public boolean validateToken(String authToken) {
//    JWTProperties jwtProperties = BeanProvider.getBean(JWTProperties.class);
//
//    String jwtSecret = jwtProperties.getSecret();
//
//    try {
//      Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
//      return true;
//    } catch (SignatureException ex) {
//      logger.error("Invalid JWT signature");
//    } catch (MalformedJwtException ex) {
//      logger.error("Invalid JWT token");
//    } catch (ExpiredJwtException ex) {
//      logger.error("Expired JWT token");
//    } catch (UnsupportedJwtException ex) {
//      logger.error("Unsupported JWT token");
//    } catch (IllegalArgumentException ex) {
//      logger.error("JWT claims string is empty.");
//    }
//    return false;
//  }
}
