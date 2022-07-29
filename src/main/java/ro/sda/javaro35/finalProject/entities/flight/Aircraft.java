package ro.sda.javaro35.finalProject.entities.flight;

import lombok.*;
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
@Table(name = "aircraft")
public class Aircraft {
    @Id
    @GeneratedValue(strategy = AUTO)
    Long id;
    @Column
    String make; // e.g. Boeing 737
    @Column
    int numberOfSeats;

    // each earcraft is used for multiple flights
    @OneToMany(mappedBy = "aircraft", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    Set<Flight> flights;

    // OneToMany for an aircraft are booked multiple tickets
    @OneToMany(mappedBy = "aircraft", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Ticket> tickets;
}