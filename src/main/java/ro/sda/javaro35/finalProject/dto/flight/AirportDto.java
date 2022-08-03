package ro.sda.javaro35.finalProject.dto.flight;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import ro.sda.javaro35.finalProject.entities.flight.Address;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class AirportDto {

    private Long id;
    private String name;

}