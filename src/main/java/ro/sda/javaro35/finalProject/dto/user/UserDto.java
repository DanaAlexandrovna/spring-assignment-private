package ro.sda.javaro35.finalProject.dto.user;

import lombok.*;
import lombok.experimental.Accessors;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String roleType;
}
