package lol.koblizek.myedu.controllers;

import lol.koblizek.myedu.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/v1/auth")
public class AuthController {

    private final UserService userService;
    private final JwtEncoder jwtEncoder;

    @Value("${jwt.expiration}")
    private int expiration;

    @Autowired
    public AuthController(UserService userService, JwtEncoder jwtEncoder) {
        this.userService = userService;
        this.jwtEncoder = jwtEncoder;
    }

    @PostMapping
    public ResponseEntity<SuccessAuthResponse> authorize(@RequestBody AuthRequest body, Authentication authentication) {
        if (userService.userExists(body.username, body.password)) {
            Instant now = Instant.now();
            String scope = authentication.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.joining(" "));
            JwtClaimsSet claims = JwtClaimsSet.builder()
                    .issuer("self")
                    .issuedAt(now)
                    .expiresAt(now.plus(Duration.ofDays(expiration)))
                    .subject(authentication.getName())
                    .claim("scope", scope)
                    .build();
            return ResponseEntity
                    .ok(new SuccessAuthResponse(jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue(), Duration.ofDays(expiration).toMinutes()));
        } else throw new BadCredentialsException("Invalid credentials");
    }

    public record SuccessAuthResponse(String token, long expire) {}

    public record AuthRequest(String username, String password) {}
}
