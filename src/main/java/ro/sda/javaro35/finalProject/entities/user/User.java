package ro.sda.javaro35.finalProject.entities.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    String id;
    @Column
    String name;

    @Column
    String lastName;

    @Column
    String dateOfBirth; // iSO Date format   yyyy-MM-dd

    @Column(nullable=false, unique = true)
    String email;

    @Column(nullable = false)
    String password;

    String position;
    @Enumerated(EnumType.STRING)
    Preferences preferences;

}
