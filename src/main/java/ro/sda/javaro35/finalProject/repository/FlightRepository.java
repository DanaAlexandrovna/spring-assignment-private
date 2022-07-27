package ro.sda.javaro35.finalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.javaro35.finalProject.dto.flight.FlightDto;
import ro.sda.javaro35.finalProject.entities.flight.Flight;

import java.util.Optional;

public interface FlightRepository extends JpaRepository<Flight, Long> {


    default Optional<Flight> flightAlreadyExists(FlightDto dto) {
        // find all flights that have the same departure, destination and flightTime
        return findAll()
                .stream()
                .filter(
                        flight -> flight.getToDestination() == dto.getToDestination() &&
                                 flight.getFromDestination() == dto.getFromDestination() &&
                                 flight.getDeparture() == dto.getDeparture() &&
                                 flight.getFlightTime() == dto.getFlightTime()
                ).findFirst();
    }
}

