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
public class FlightDto {

    private Long id;
    private String departure;
    private int flightTime;
    private int gate;
    private double price;
}
