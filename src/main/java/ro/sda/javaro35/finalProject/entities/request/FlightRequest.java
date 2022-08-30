package ro.sda.javaro35.finalProject.entities.request;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class FlightRequest {

    private final Long id;
    private final String departure;
    private final double price;
}
