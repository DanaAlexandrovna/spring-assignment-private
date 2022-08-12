package ro.sda.javaro35.finalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.javaro35.finalProject.entities.flight.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {

}