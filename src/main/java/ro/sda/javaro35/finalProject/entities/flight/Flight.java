package ro.sda.javaro35.finalProject.entities.flight;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

import java.util.Set;

import static javax.persistence.GenerationType.AUTO;
import static lombok.AccessLevel.PRIVATE;

@ToString
@RequiredArgsConstructor
@Data
@Entity
@FieldDefaults(level = PRIVATE)
@Table(name = "flight")
public class Flight {
    @org.springframework.data.annotation.Id
    @GeneratedValue(strategy = AUTO)
    @Id
    Long id;

    // when does the flight take place
    @Column
    String departure;  // ISO format datetime e.g.
    // yyyy-MM-DD'T'HH:mm:ss
    @Column
    int flightTime; // how many minutes does the flight take

    // which gate
    @Column
    int gate;

    // which price
    @Column
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
    @JoinColumn(name = "aircraft_id", nullable = false)
    Airport airport;

    // multiple flights can be booked by multiple users

    // multiple users use multiple flights
    @ManyToMany
    @JoinTable(
            name = "joined_user_flight",
            joinColumns = @JoinColumn(name = "flight_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    Set<Flight> flights;

}
