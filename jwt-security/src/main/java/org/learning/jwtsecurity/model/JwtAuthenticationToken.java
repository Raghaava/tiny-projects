package org.learning.jwtsecurity.model;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

//Required to invoke Authentication Manager
public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken {

    private String token;

    public JwtAuthenticationToken(String token) {
        super(null, null);
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
