package ro.sda.javaro35.finalProject.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.AUTO;
import static lombok.AccessLevel.PRIVATE;

@Data
@NoArgsConstructor
@Entity(name = "flights")
@FieldDefaults(level = PRIVATE)
public class Flight {

    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = AUTO)
    String id;
    @Column
    String fromDestination;
    @Column
    String toDestination;
    @Column
    String decolare;  // ISO format datetime e.g.
    // yyyy-MM-DD'T'HH:mm:ss
    @Column
    int flightTime; // how many minutes does the flight take
    @Column
    String flightCode;


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
