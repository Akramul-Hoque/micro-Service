package hotelManagment.authService.user.service;

import hotelManagment.authService.user.Dto.request.LoginRequest;
import hotelManagment.authService.user.Dto.response.LoginResponse;

public interface AuthService {
    LoginResponse authenticateUser(LoginRequest loginRequest);
//    LoginResponse authenticateUser(LoginRequest request);
}
