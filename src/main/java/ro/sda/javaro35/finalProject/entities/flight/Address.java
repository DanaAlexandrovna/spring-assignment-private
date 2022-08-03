package ro.sda.javaro35.finalProject.entities.flight;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import static lombok.AccessLevel.PRIVATE;

@ToString
@RequiredArgsConstructor
@Data
@Entity
@FieldDefaults(level = PRIVATE)
@Table(name = "address")
public class Address {

    @Id
    @Column(name = "id")
    private Long id;
    @Column
    String country; // country

    @Column
    String address; // city, street, number

}
