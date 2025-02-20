package hotelManagment.userService.user.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdDateTime;

    @PrePersist
    protected void onCreate() {
        this.createdDateTime = LocalDateTime.now();
    }
}

