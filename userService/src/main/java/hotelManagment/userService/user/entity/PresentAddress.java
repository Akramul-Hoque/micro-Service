package hotelManagment.userService.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_present_addresses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PresentAddress extends BaseEntity{
    private String road;
    private String post;
    private String city;
}
