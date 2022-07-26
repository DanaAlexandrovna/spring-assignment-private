package ro.sda.javaro35.finalProject.dto.flight;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.metamodel.SingularAttribute;
import java.io.Serializable;
import java.util.Optional;

@Getter
@Setter
public class FlightResponse {

    private String id;
    private String fromDestination;
    private String toDestination;
    private double price;
    private int quantity;
    private String departure;
    private int flightTime;
    private String flightCode;

}
