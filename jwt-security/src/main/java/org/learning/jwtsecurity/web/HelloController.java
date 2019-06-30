package org.learning.jwtsecurity.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    @PreAuthorize("hasRole('user_role')")
    public String sayHello() {
        return "Hello Raghava!";
    }
}
