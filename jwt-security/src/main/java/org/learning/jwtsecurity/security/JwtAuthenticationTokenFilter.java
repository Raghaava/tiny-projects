package org.learning.jwtsecurity.security;

import org.learning.jwtsecurity.model.JwtAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
    1) extract authorization header
    2) create JwtAuthenticationToken
    3) call AuthenticationManager
 */
public class JwtAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter {
    public JwtAuthenticationTokenFilter() {
        super("/hello");
    }

    @Override
    public Authentication attemptAuthentication(
            HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws AuthenticationException, IOException, ServletException {
        String authrozation = httpServletRequest.getHeader("Authrozation");
        if (StringUtils.isEmpty(authrozation)) {
            throw new RuntimeException("JWT token is missing");
        }
        String token = authrozation.substring(6);
        JwtAuthenticationToken jwtAuthenticationToken = new JwtAuthenticationToken(token);
        return getAuthenticationManager().authenticate(jwtAuthenticationToken);
    }

    @Override
    protected void successfulAuthentication(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain,
            Authentication authResult)
            throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
        chain.doFilter(request, response);
    }
}
