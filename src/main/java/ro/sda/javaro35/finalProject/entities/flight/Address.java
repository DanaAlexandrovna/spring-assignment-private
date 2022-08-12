package ro.sda.javaro35.finalProject.entities.flight;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

import static lombok.AccessLevel.PRIVATE;

@ToString
@RequiredArgsConstructor
@Getter
@Setter
@Entity
@FieldDefaults(level = PRIVATE)
@Table(name = "address")
public class Address {

    @Id
    @Column(name = "id")
    private Long id;

    String country; // country


    String address; // city, street, number


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "airport_id", referencedColumnName = "id")
    private Airport airport;

}
