package hotelManagment.userService.user.entity;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseEntity{

    // Basic user information
    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String role;  // e.g., USER or ADMIN

    // Additional fields from your original POJO
    private String age;
//    private String address;
    private String dob;
    private String nid;

    // One-to-one association for permanent address
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "permanent_address_id", referencedColumnName = "id")
    private PermanentAddress userPermanentAddress;

    // One-to-one association for present address
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "present_address_id", referencedColumnName = "id")
    private PresentAddress userPresentAddress;
}
