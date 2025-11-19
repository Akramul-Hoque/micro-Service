package hotelManagment.authService.user.controller;

import hotelManagment.authService.user.Dto.request.LoginRequest;
import hotelManagment.authService.user.Dto.request.UserRequest;
import hotelManagment.authService.user.Dto.response.CommonResponse;
import hotelManagment.authService.user.Dto.response.LoginResponse;
import hotelManagment.authService.user.Dto.response.UserResponse;
import hotelManagment.authService.user.service.AuthService;
import hotelManagment.authService.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final AuthService authService;

    public UserController(UserService userService, AuthService authService) {
        this.userService = userService;
        this.authService = authService;
    }


    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginRequest loginRequest) {
        LoginResponse loginResponse = authService.authenticateUser(loginRequest);
        return ResponseEntity.ok(loginResponse);
    }

    @PostMapping("/register")
    public ResponseEntity<CommonResponse<UserResponse>> registerUser(@RequestBody UserRequest userRequest) {
        CommonResponse<UserResponse> response = userService.createUser(userRequest);
        return ResponseEntity.status(response.getCode()).body(response);
    }

    @GetMapping("/{username}")
    public ResponseEntity<CommonResponse<UserResponse>> getUserByUsername(@PathVariable String username) {
        CommonResponse<UserResponse> response = userService.getUserByUsername(username);
        if (response.getCode() == 200) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}
