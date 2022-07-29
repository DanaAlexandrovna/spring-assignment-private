package ro.sda.javaro35.finalProject.entities.user;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import javax.validation.constraints.Email;
import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    Long id;
    @Column
    String name;
    @Column
    String lastName;
//    @Column
//    String dateOfBirth; // iSO Date format   yyyy-MM-dd
    @Column(nullable=false, unique=true)
    @Email
    String email;
    @Column(nullable=false)
    String password;

    String roles;

}
