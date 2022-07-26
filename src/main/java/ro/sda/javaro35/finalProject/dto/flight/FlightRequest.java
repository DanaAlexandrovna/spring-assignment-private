package ro.sda.javaro35.finalProject.dto.flight;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlightRequest {

    private String fromDestination;
    private String toDestination;
    private double price;
    private int quantity;
    private String departure;
    private int flightTime;
    private String flightCode;
}
