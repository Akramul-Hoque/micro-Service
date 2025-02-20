package hotelManagment.userService.user.Dto.response;

import lombok.Data;

@Data
public class LoginResponse {
    private String auhToken;
    private String refreshToken;
}
