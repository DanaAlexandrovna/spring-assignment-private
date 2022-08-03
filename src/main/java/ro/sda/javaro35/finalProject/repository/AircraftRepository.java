package ro.sda.javaro35.finalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.javaro35.finalProject.dto.flight.AircraftDto;
import ro.sda.javaro35.finalProject.entities.flight.Aircraft;

import java.util.Optional;

public interface AircraftRepository extends JpaRepository<Aircraft, Long> {

}
