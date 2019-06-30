package org.learning.jwtsecurity.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.learning.jwtsecurity.model.JwtUser;
import org.springframework.stereotype.Component;

@Component
public class JwtGenerator {
    public String generate(JwtUser jwtUser) {
        Claims claims = Jwts.claims().setSubject(jwtUser.getUserName());
        claims.put("userId", jwtUser.getId());
        claims.put("role", jwtUser.getRole());

        return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, "youtube").compact();
    }
}
