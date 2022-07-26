package ro.sda.javaro35.finalProject.services.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.javaro35.finalProject.dto.flight.FlightRequest;
import ro.sda.javaro35.finalProject.entities.flight.Flight;
import ro.sda.javaro35.finalProject.exceptions.ThisAlreadyExistsException;
import ro.sda.javaro35.finalProject.repository.FlightRepository;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class FlightServices {

    private static final Logger log = LoggerFactory.getLogger(FlightServices.class);

    private final FlightRepository flightRepository;

    @Autowired
    public FlightServices(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public void save(@Valid Flight flight) {
        log.info("saving product {}",flight.getId());
        flightRepository.save(flight);
    }

    // find all
    public List<Flight> findAll() {
        log.info("finding all flights");
        return flightRepository.findAll();    }
    // find by id
    public Flight findById(Long id) {
        log.info("finding by id");
        return flightRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("this flight can't be found"));
    }

    // update
    public void update(Long productId, FlightRequest productData) {
        log.info("update product {}", productData);

        flightRepository.findById(productId)
                .map(existingProduct -> updateEntity(productData, existingProduct))
                .map(updatedProduct -> flightRepository.save(updatedProduct))
                .orElseThrow(() -> new RuntimeException("product not found"));
    }

    private Flight updateEntity(FlightRequest flightData, Flight existingFlight) {
        existingFlight.setFromDestination(flightData.getFromDestination());
        existingFlight.setToDestination(flightData.getToDestination());
        existingFlight.setPrice(flightData.getPrice());
        existingFlight.setQuantity(flightData.getQuantity());
        existingFlight.setDeparture(flightData.getDeparture());
        existingFlight.setFlightTime(flightData.getFlightTime());
        existingFlight.setFlightCode(flightData.getFlightCode());
        return existingFlight;
    }

    public void partialUpdate(Flight flight) {
        log.info("update product {}", flight);

        String name = flight.getId();
        flightRepository.findByNameIgnoreCase(name)
                .filter(existingProduct -> existingProduct.getId().equals(flight.getId()))
                .map(existingProduct -> flightRepository.save(flight))
                .orElseThrow(() -> {
                    log.error("product with id {} already exists", id);
                    throw new ThisAlreadyExistsException("flight with " + id + " already exists");
                });
    }

    // delete
    @Transactional
    public void delete(String id) {
        log.info("deleting by id");
        flightRepository.deleteById(id);
    }

}

