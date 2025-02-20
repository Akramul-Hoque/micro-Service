package hotelManagment.userService.user.service;

import hotelManagment.userService.user.Dto.request.LoginRequest;
import hotelManagment.userService.user.Dto.response.LoginResponse;
import hotelManagment.userService.user.repository.UserRepository;
import hotelManagment.userService.util.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{
//    private final AuthenticationManager authenticationManager;
//    private final UserDetailsService userDetailsService;
//    private final JwtTokenUtil jwtTokenUtil;
//    private final UserRepository userRepository;
//
////    public AuthServiceImpl(AuthenticationManager authenticationManager, UserDetailsService userDetailsService, JwtTokenUtil jwtTokenUtil, UserRepository userRepository) {
////        this.authenticationManager = authenticationManager;
////        this.userDetailsService = userDetailsService;
////        this.jwtTokenUtil = jwtTokenUtil;
////        this.userRepository = userRepository;
////    }
//
//    @Override
//    public LoginResponse authenticateUser(LoginRequest request) {
//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
//        );
//
//        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
//        String jwtToken = jwtTokenUtil.generateToken(userDetails);
//        String refreshToken = jwtTokenUtil.generateRefreshToken(userDetails);
//
//        return LoginResponse.builder()
//                .jwtToken(jwtToken)
//                .refreshToken(refreshToken)
//                .message("Login successful")
//                .build();
//    }
}
