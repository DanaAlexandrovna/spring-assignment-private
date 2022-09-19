package ro.sda.javaro35.finalProject.entities.flight;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(generator= ObjectIdGenerators.UUIDGenerator.class, property="@id")
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