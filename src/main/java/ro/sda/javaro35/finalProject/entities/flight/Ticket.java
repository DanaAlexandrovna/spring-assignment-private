package ro.sda.javaro35.finalProject.entities.flight;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

import java.util.Set;

import static javax.persistence.GenerationType.AUTO;
import static lombok.AccessLevel.PRIVATE;

@ToString
@RequiredArgsConstructor
@Data
@Entity
@FieldDefaults(level = PRIVATE)
@Table(name = "ticket")
public class Ticket {
    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = AUTO)
    Long id;

    @Column
    int quantity;

    String flightCode;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


    // for each Ticket we have an unique aircraft
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Aircraft aircraft;
}
