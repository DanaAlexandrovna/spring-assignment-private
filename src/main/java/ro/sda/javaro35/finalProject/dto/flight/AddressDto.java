package ro.sda.javaro35.finalProject.dto.flight;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class AddressDto {

    private Long id;
    private String country;
    private String address;

}
