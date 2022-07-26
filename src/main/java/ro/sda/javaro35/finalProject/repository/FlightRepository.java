package ro.sda.javaro35.finalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.javaro35.finalProject.dto.flight.FlightRequest;
import ro.sda.javaro35.finalProject.entities.flight.Flight;

import java.util.List;
import java.util.Optional;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findAll();
    Optional<Flight> findById(Long id);
    Optional<Flight> findFlightByFromDestination(String fromDestination);
    Optional<Flight> findFlightByToDestination (String toDestination);
    List<Flight> findFlightByDeparture(String departure);
    Optional<Flight> findFlightByFlightTime(Integer flightTime);
    Optional<Flight> findFlightByFlightCode(String flightCode);

    default Optional<Flight> flightAlreadyExists(FlightRequest createFlightRequest) {
        // find all gflights that have the same departure, destination and flightTime
        return findAll()
                .stream()
                .filter(
                        flight -> flight.getToDestination() == createFlightRequest.getToDestination() &&
                                 flight.getFromDestination() == createFlightRequest.getFromDestination() &&
                                 flight.getDeparture() == createFlightRequest.getDeparture() &&
                                 flight.getFlightTime() == createFlightRequest.getFlightTime()
                ).findFirst();
    }
}

