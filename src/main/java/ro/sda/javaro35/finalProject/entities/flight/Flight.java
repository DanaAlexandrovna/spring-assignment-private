package ro.sda.javaro35.finalProject.entities.flight;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.util.Objects;

import static javax.persistence.GenerationType.AUTO;
import static lombok.AccessLevel.PRIVATE;

@Data
@Getter
@Setter
@NoArgsConstructor
@Entity(name = "flights")
@FieldDefaults(level = PRIVATE)
public class Flight {
    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = AUTO)
    Long id;
    @Column
    String fromDestination;
    @Column
    String toDestination;
    @Column
    double price;
    @Column
    int quantity;
    @Column
    String departure;  // ISO format datetime e.g.
    // yyyy-MM-DD'T'HH:mm:ss
    @Column
    int flightTime; // how many minutes does the flight take
    @Column
    String flightCode;


    @Override
    public String toString() {
        return "Flight{" +
                "id='" + id + '\'' +
                ", fromDestination='" + fromDestination + '\'' +
                ", toDestination='" + toDestination + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", departure='" + departure + '\'' +
                ", flightTime=" + flightTime +
                ", flightCode='" + flightCode + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Double.compare(flight.price, price) == 0 && quantity == flight.quantity && flightTime == flight.flightTime && Objects.equals(id, flight.id) && Objects.equals(fromDestination, flight.fromDestination) && Objects.equals(toDestination, flight.toDestination) && Objects.equals(departure, flight.departure) && Objects.equals(flightCode, flight.flightCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fromDestination, toDestination, price, quantity, departure, flightTime, flightCode);
    }
}
