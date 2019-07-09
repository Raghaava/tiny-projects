package org.learning.jwtsecurity.web;

import lombok.Data;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/user")
public class UserController {
    private ConcurrentHashMap<Long, User> users = new ConcurrentHashMap();
    private AtomicLong id = new AtomicLong(0);

    @PostMapping("/")
    @PreAuthorize("hasRole('ROLE_USER')")
    public User createUser(@RequestBody User user)
    {
        user.setId(id.incrementAndGet());
        users.put(user.getId(), user);
        return user;
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public User deleteUser(@RequestBody User user, @PathVariable Long id){
        user.setId(id);
        users.put(user.getId(), user);
        return user;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public User getUser(@PathVariable Long id){
        return users.get(id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public User deleteUser(@PathVariable Long id){
        return users.remove(id);
    }
}

@Data
class User
{
    private Long id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
}
