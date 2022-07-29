package ro.sda.javaro35.finalProject.repository;

import ro.sda.javaro35.finalProject.dto.flight.AircraftDto;
import ro.sda.javaro35.finalProject.entities.flight.Aircraft;
import ro.sda.javaro35.finalProject.entities.user.User;

import java.util.Optional;

public interface AircraftRepository {

    Optional<Aircraft> findById(Long id);

    void save(AircraftDto aircraft);

}
