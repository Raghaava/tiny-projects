package org.learning.jwtsecurity.web;

import org.learning.jwtsecurity.model.JwtUser;
import org.learning.jwtsecurity.security.JwtGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenController {
    @Autowired
    private JwtGenerator jwtGenerator;

    @PostMapping("/token")
    public String generateToken(@RequestBody JwtUser jwtUser) {
        return jwtGenerator.generate(jwtUser);
    }
}
