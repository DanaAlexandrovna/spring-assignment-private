package ro.sda.javaro35.finalProject.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import ro.sda.javaro35.finalProject.entities.Flight;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ToString
//@JsonInclude(value = JsonInclude.Include.NON_NULL)
//@JsonIgnoreProperties(ignoreUnknown = true)
public class FlightDto {
    private String id;
    private String fromDestination;
    private String toDestination;
    private int flightTime;
    private String flightCode;
}
