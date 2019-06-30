package org.learning.jwtsecurity.security;

import org.learning.jwtsecurity.model.JwtAuthenticationToken;
import org.learning.jwtsecurity.model.JwtUser;
import org.learning.jwtsecurity.model.JwtUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
// Key impl where actual authentication take place
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @Autowired
    private JwtValidator jwtValidator;

    @Override
    protected void additionalAuthenticationChecks(
            UserDetails userDetails,
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken)
            throws AuthenticationException {
    }

    @Override
    protected UserDetails retrieveUser(
            String userName, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken)
            throws AuthenticationException {
        JwtAuthenticationToken jwtToken = (JwtAuthenticationToken) usernamePasswordAuthenticationToken;
        String token = jwtToken.getToken();
        JwtUser user = jwtValidator.validate(token);
        List<GrantedAuthority> authorityList =
                AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRole());
        return new JwtUserDetails(user.getUserName(), authorityList, token, user.getId());
    }
}