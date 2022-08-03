package ro.sda.javaro35.finalProject.entities.flight;

import lombok.*;
import lombok.experimental.FieldDefaults;
import ro.sda.javaro35.finalProject.entities.user.User;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.GenerationType.AUTO;
import static lombok.AccessLevel.PRIVATE;

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

    int flightTime; // how many minutes does the flight take

    // which gate
    int gate;

    // which price
    double price;

    // oneToMany relation to Airport:
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "from_airport_id", nullable = false)
    private Airport fromAirport;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "to_airport_id", nullable = false)
    private Airport toAirport;

    // multiple planes use the same one plane
    // ManyToOne relation with planes
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "destination_airport_id", nullable = false)
    Airport airport;

    // multiple flights can be booked by multiple users
    @ManyToMany
    @JoinTable(
            name = "joined_user_flight",
            joinColumns = @JoinColumn(name = "flight_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    Set<User> users;
    @ManyToOne
    @JoinColumn(name = "aircraft_id")
    Aircraft aircraft;
}
