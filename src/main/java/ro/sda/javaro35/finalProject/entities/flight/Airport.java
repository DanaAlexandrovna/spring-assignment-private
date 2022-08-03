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
@Table(name = "airport")
public class Airport {

    @Id
    @GeneratedValue(strategy = AUTO)
    Long id;
    @Column
    String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToMany(mappedBy = "airport", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set <Aircraft> aircraft;

}