package hotelManagment.userService.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenUtil {
    private final String secretKey = "a1B2c3D4e5F6g7H8i9J0k1L2m3N4o5P6q7R8s9T0u1V2w3X4y5Z6";
    private final long expirationTime = 1000 * 60 * 60;  // 1 hour in milliseconds

    public String generateToken(Authentication authentication) {
        String username = getUsernameFromAuthentication(authentication);

        return JWT.create()
                .withSubject(username)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + expirationTime)) // Set expiration
                .sign(Algorithm.HMAC512(secretKey)); // Sign the JWT with the secret key
    }

    private String getUsernameFromAuthentication(Authentication authentication) {
        Object principal = authentication.getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        }
        return principal.toString();  // If principal is not an instance of UserDetails, fallback to toString()
    }

    public String extractUsername(String token) {
        return extractClaim(token, DecodedJWT::getSubject);  // Subject is the username in our case
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, DecodedJWT::getExpiresAt);
    }

    public <T> T extractClaim(String token, java.util.function.Function<DecodedJWT, T> claimResolver) {
        DecodedJWT decodedJWT = decodeToken(token);
        return claimResolver.apply(decodedJWT);
    }

    private DecodedJWT decodeToken(String token) {
        return JWT.require(Algorithm.HMAC512(secretKey))
                .build()
                .verify(token);
    }

    public boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public boolean validateToken(String token) {
        return !isTokenExpired(token);
    }
}