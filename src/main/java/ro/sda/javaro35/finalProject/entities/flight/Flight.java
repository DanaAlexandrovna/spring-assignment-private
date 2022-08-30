package ro.sda.javaro35.finalProject.entities.flight;

import lombok.*;
import lombok.experimental.FieldDefaults;
import ro.sda.javaro35.finalProject.entities.user.User;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.GenerationType.AUTO;
import static lombok.AccessLevel.PRIVATE;

@ToString
@RequiredArgsConstructor
@Getter
@Setter
@Entity
@FieldDefaults(level = PRIVATE)
@Table(name = "flight")
public class Flight {

    @Id
    @GeneratedValue(strategy = AUTO)
    Long id;

    // when does the flight take place

    String departure;  // ISO format datetime e.g.
    // yyyy-MM-DD'T'HH:mm:ss

    // which price
    double price;

    // oneToMany relation to Airport:
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "from_airport_id", nullable = false)
    private Airport fromAirport;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "to_airport_id", nullable = false)
    private Airport toAirport;



    // one flight to many tickets
    @OneToMany(mappedBy = "flight", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set <Ticket> tickets;

}
