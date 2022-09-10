package ro.sda.javaro35.finalProject.service.flight;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.javaro35.finalProject.entities.flight.Aircraft;
import ro.sda.javaro35.finalProject.exceptions.CantBeFoundException;
import ro.sda.javaro35.finalProject.repository.AircraftRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class AircraftService {

    private final AircraftRepository aircraftRepository;

    @PersistenceContext
    private EntityManager entityManager;


    //create airport
    public Aircraft addAircraft(Aircraft aircraft) {
        aircraft.setMake(aircraft.getMake());
        return aircraftRepository.save(aircraft);
    }

    //save seats randomly
    public Aircraft saveSeat(Aircraft seats) {
        seats.setNumberOfSeats(Integer.parseInt(UUID.randomUUID().toString()));
        return aircraftRepository.save(seats);
    }

    public Aircraft findById(Long id) {
        return aircraftRepository.findById(id).orElseThrow(() -> new CantBeFoundException("Aircraft by id" + id + "cannot be found"));
    }


    public Aircraft updateAircraft(Aircraft update) {
        return aircraftRepository.save(update);
    }

    public void deleteAircraft(Long id) {
        aircraftRepository.deleteById(id);
    }
}
