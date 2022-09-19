package ro.sda.javaro35.finalProject.entities.flight;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import lombok.experimental.FieldDefaults;

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
@Table(name = "aircraft")
@JsonIdentityInfo(generator= ObjectIdGenerators.UUIDGenerator.class, property="@id")
public class Aircraft {
    @Id
    @GeneratedValue(strategy = AUTO)
    Long id;

    String make; // e.g. Boeing 737

    int numberOfSeats;


    @OneToMany(mappedBy = "aircraft", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Ticket> tickets;
}