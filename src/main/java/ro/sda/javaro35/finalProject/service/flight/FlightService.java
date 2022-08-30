package ro.sda.javaro35.finalProject.service.flight;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.javaro35.finalProject.entities.flight.Airport;
import ro.sda.javaro35.finalProject.entities.flight.Flight;
import ro.sda.javaro35.finalProject.exceptions.CantBeFoundException;
import ro.sda.javaro35.finalProject.repository.FlightRepository;

@Service
@Transactional
@AllArgsConstructor
public class FlightService {

    private final FlightRepository flightRepository;

    //save ??????
    public Flight addFlight(Flight flight) {
        flight.setDeparture(flight.getDeparture());
        flight.setPrice(flight.getPrice());
        return flightRepository.save(flight);
    }

    public Flight findById(Long id) {
        return flightRepository.findById(id).orElseThrow(() -> new CantBeFoundException("Flight by id" + id + "cannot be found"));
    }


    //update
    public Flight updateFlight(Flight update) {
        return flightRepository.save(update);
    }

    //delete
    public void delete(Long id) {
        flightRepository.deleteById(id);
    }
}
