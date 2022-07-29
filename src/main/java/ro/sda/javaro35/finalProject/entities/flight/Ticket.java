package ro.sda.javaro35.finalProject.entities.flight;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.AUTO;
import static lombok.AccessLevel.PRIVATE;
@ToString
@RequiredArgsConstructor
@Data
@Entity
@FieldDefaults(level = PRIVATE)
public class Ticket {
    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = AUTO)
    Long id;
    @Column
    String fromDestination;
    @Column
    String toDestination;
    @Column
    double price;
    @Column
    int quantity;
    @Column
    String departure;  // ISO format datetime e.g.
    // yyyy-MM-DD'T'HH:mm:ss
    @Column
    int flightTime; // how many minutes does the flight take
    @Column
    String flightCode;

}
