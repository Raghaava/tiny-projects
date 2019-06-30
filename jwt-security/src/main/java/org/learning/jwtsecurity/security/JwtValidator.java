package org.learning.jwtsecurity.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.learning.jwtsecurity.model.JwtUser;
import org.springframework.stereotype.Component;

@Component
public class JwtValidator {
  public JwtUser validate(String token) {
    Claims claims = Jwts.parser().setSigningKey("youtube").parseClaimsJws(token).getBody();

    JwtUser user = new JwtUser();
    user.setUserName(claims.getSubject());
    user.setId(Long.valueOf((Integer)claims.get("userId")));
    user.setRole((String) claims.get("role"));
    return user;
  }
}
