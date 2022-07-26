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
    @NotNull
    @NotEmpty
    private String id;
    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @NotEmpty
    private String lastName;
    @NotNull
    @NotEmpty
    private String dateOfBirth;
    @NotNull
    @NotEmpty
    private String email;
    @NotNull
    @NotEmpty
    private String password;

}
