package ro.sda.javaro35.finalProject.service;

import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.javaro35.finalProject.dto.flight.FlightDto;
import ro.sda.javaro35.finalProject.entities.flight.Flight;
import ro.sda.javaro35.finalProject.exceptions.CantBeFoundException;
import ro.sda.javaro35.finalProject.exceptions.FlightCantBeFoundException;
import ro.sda.javaro35.finalProject.exceptions.ThisAlreadyExistsException;
import ro.sda.javaro35.finalProject.repository.FlightRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

import static lombok.AccessLevel.PRIVATE;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
@Slf4j
@AllArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class FlightService {
    final FlightRepository flightRepository;
    final FlightDto flightDto;

    public void save(@Valid Flight flight) {
        log.info("saving product {}", flight.getId());
        flightRepository.save(flight);
    }

    // find all
    public List<Flight> findAll() {
        log.info("finding all flights");
        return flightRepository.findAll();
    }

    // find by id
    public Flight findById(Long id) {
        log.info("finding by id");
        return flightRepository.findById(id)
                .orElseThrow(() -> new FlightCantBeFoundException("this flight can't be found"));
    }

    // update
    public void update(Long flightId, FlightDto flightData) {
        log.info("update flight {}", flightData);

        Flight Flight = new Flight();
        flightRepository.findById(flightId)
                .map(existingFlight -> updateEntity(flightData, existingFlight))
                .map(updatedProduct -> flightRepository.save(Flight))
                .orElseThrow(() -> new CantBeFoundException("flight not found"));
    }

    private Flight updateEntity(FlightDto flightData, Flight existingFlight) {
        existingFlight.setFromDestination(flightData.getFromDestination());
        existingFlight.setToDestination(flightData.getToDestination());
        existingFlight.setPrice(flightData.getPrice());
        existingFlight.setQuantity(flightData.getQuantity());
        existingFlight.setDeparture(flightData.getDeparture());
        existingFlight.setFlightTime(flightData.getFlightTime());
        existingFlight.setFlightCode(flightData.getFlightCode());
        return existingFlight;
    }

    public partialUpdate( ) {
        log.info("update flight {}", Flight);
        flightDto.flightAlreadyExists(FlightRepository dto)
                .filter(existingProduct -> existingProduct.getId().equals(dto.getId()))
                .map(existingProduct -> flightDto.save(dto))
                .orElseThrow(() -> {
                    log.error("product with id {} already exists", id);
                    throw new ThisAlreadyExistsException("flight with " + id + " already exists");
                });
    }

    // delete
    @Transactional
    public void delete(Long id) {
        log.info("deleting by id");
        flightRepository.deleteById(id);
    }

}

