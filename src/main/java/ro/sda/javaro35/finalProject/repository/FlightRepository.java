package ro.sda.javaro35.finalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.javaro35.finalProject.entities.Flight;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {


}

