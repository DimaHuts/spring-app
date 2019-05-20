package notebook.util.jwt;

import io.jsonwebtoken.*;
import notebook.property.JWTProperties;
import notebook.service.common.BeanProvider;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {

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
}
