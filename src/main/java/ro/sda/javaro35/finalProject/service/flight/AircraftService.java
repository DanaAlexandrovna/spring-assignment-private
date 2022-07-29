package ro.sda.javaro35.finalProject.service.flight;

import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ro.sda.javaro35.finalProject.dto.flight.AircraftDto;
import ro.sda.javaro35.finalProject.dto.flight.AirportDto;
import ro.sda.javaro35.finalProject.repository.AircraftRepository;

import static lombok.AccessLevel.PRIVATE;

@Service
@Slf4j
@AllArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class AircraftService {

    AircraftRepository aircraftRepository;

    //create airport
    public void save(AircraftDto aircraft) {
        log.info("saving the airport = {}", aircraft.getAirlineCompany());
        aircraftRepository.save(aircraft);
    }

    //save seats randomly

    //update the random seat by choosing one
}
