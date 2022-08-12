package ro.sda.javaro35.finalProject.entities.user;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;
import ro.sda.javaro35.finalProject.entities.flight.Address;
import ro.sda.javaro35.finalProject.entities.flight.Aircraft;
import ro.sda.javaro35.finalProject.entities.flight.Flight;
import ro.sda.javaro35.finalProject.entities.flight.Ticket;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Set;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    Long id;

    String firstName;
    String lastName;

    @Column(nullable=false, unique=true)
    @Email
    String email;
    @Column(nullable=false)
    String password;

    String roles;


    // one user buys many tickets
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set <Ticket> tickets;

}
