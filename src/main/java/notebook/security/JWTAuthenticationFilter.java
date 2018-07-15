package notebook.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import notebook.entity.User;
import notebook.enums.Security;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
  private final AuthenticationManager authenticationManager;

  public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
    this.authenticationManager = authenticationManager;
  }

  public Authentication attemptAuthentication(HttpServletRequest req,
                                              HttpServletResponse res) throws AuthenticationException {
    try {
      User creds = new ObjectMapper()
        .readValue(req.getInputStream(), User.class);

      return authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
          creds.getEmail(),
          creds.getPassword(),
          new ArrayList<>())
      );
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res,
                                          FilterChain chain, Authentication auth) {
    String token = Jwts.builder()
      .setSubject(((User) auth.getPrincipal()).getEmail())
      .setExpiration(new Date(System.currentTimeMillis() + Integer.parseInt(Security.EXPIRATION_TIME.getValue())))
      .signWith(SignatureAlgorithm.HS512, Security.SECRET.getValue().getBytes())
      .compact();
    res.addHeader(Security.HEADER_STRING.getValue(), Security.TOKEN_PREFIX.getValue() + token);
  }
}
