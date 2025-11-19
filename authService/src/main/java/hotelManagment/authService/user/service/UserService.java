package hotelManagment.authService.user.service;
import hotelManagment.authService.user.Dto.request.UserRequest;
import hotelManagment.authService.user.Dto.response.CommonResponse;
import hotelManagment.authService.user.Dto.response.UserResponse;

public interface UserService {
    CommonResponse createUser(UserRequest user);

    CommonResponse<UserResponse> getUserByUsername(String username);
}
