package ro.sda.javaro35.finalProject.entities.flight;

import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import static javax.persistence.GenerationType.AUTO;
import static lombok.AccessLevel.PRIVATE;
@ToString
@RequiredArgsConstructor
@Data
@Entity
@FieldDefaults(level = PRIVATE)
public class Airport {

    @Id
    @GeneratedValue(strategy = AUTO)
    Long id;
    @Column
    String name;
    @Column
    int gate;

}