
package ro.sda.javaro35.finalProject.service.flight.service;

import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ro.sda.javaro35.finalProject.dto.flight.AircraftDto;
import ro.sda.javaro35.finalProject.entities.flight.Aircraft;
import ro.sda.javaro35.finalProject.repository.AircraftRepository;
import ro.sda.javaro35.finalProject.service.flight.mapper.AircraftMapper;

import java.util.Random;
import java.util.stream.IntStream;

import static lombok.AccessLevel.PRIVATE;

@Service
@Slf4j
@AllArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class AircraftService {

    AircraftRepository aircraftRepository;
    AircraftMapper aircraftMapper;

    //create airport
    public AircraftDto save(AircraftDto form) {
        log.info("saving the airport = {}", form.getMake());
        Aircraft aircraft = aircraftMapper.convertToEntity(form);
        aircraft = aircraftRepository.save(aircraft);
        return aircraftMapper.convertToDto(aircraft);
    }

    //save seats randomly
//    public void saveSeats(AircraftDto dto){
//        IntStream limitedIntStream = random.ints(streamSize);
//        log.info("saving seat randomly ={}", int numberOfSeats);
//
//    }

    public static int getRandomSeat(AircraftDto seats){
        log.info("getting a random seat {}");
        Random random = new Random();
        return random.ints().findFirst().getAsInt();
    }
    //update the random seat by choosing one
}
