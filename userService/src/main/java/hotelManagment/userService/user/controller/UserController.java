package hotelManagment.userService.user.controller;

import hotelManagment.userService.user.Dto.request.UserRequest;
import hotelManagment.userService.user.Dto.response.CommonResponse;
import hotelManagment.userService.user.Dto.response.UserResponse;
import hotelManagment.userService.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
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
