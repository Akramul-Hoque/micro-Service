package hotelManagment.authService.user.service;

import hotelManagment.authService.user.Dto.request.LoginRequest;
import hotelManagment.authService.user.Dto.response.LoginResponse;
import hotelManagment.authService.util.JwtTokenUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    public AuthServiceImpl(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    public LoginResponse authenticateUser(LoginRequest loginRequest) {
        // Authenticate the user
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword())
        );

        // Generate JWT token
        String jwtToken = jwtTokenUtil.generateToken(authentication);

        // Return the JWT token in response
        return new LoginResponse(jwtToken);
    }
}
