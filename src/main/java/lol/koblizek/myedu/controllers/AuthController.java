package lol.koblizek.myedu.controllers;

import lol.koblizek.myedu.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/auth")
public class AuthController {

    private final UserService userService;

    @Value("${jwt.expiration}")
    private int expiration;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void authorize(@RequestBody AuthRequest body, Authentication authentication) {
        if (userService.userExists(body.username, body.password)) {

        } else throw new BadCredentialsException("Invalid credentials");
    }

    public record AuthRequest(String username, String password) {}
}
