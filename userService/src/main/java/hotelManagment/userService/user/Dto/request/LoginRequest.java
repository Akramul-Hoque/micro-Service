package hotelManagment.userService.user.Dto.request;

import lombok.Data;

@Data
public class LoginRequest {
    private String userName;
    private String password;
}
