package ro.sda.javaro35.finalProject.entities.request;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class AircraftRequest {

    private final Long id;
    private final String make;
    private final int numberOfSeats;
}
