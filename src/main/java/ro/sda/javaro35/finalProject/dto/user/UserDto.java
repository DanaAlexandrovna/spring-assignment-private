package ro.sda.javaro35.finalProject.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class UserDto {
    private Long id;
    private String name;
    private String lastName;
    private String dateOfBirth;
    private String email;
    private String password;
    private String roles;

}
