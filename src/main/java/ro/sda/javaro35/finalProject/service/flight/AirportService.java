package ro.sda.javaro35.finalProject.service.flight;

import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ro.sda.javaro35.finalProject.dto.flight.AirportDto;
import ro.sda.javaro35.finalProject.repository.AirportRepository;
import java.util.List;
import static lombok.AccessLevel.PRIVATE;

@Service
@Slf4j
@AllArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class AirportService {

    final AirportRepository airportRepository;
    ModelMapper modelMapper;
    AirportMapper airportMapper;

    //save
    public void save(AirportDto airport){
        log.info("saving the airport = {}", airport.getName());
        airportRepository.save(airport);
    }

    public List<AirportDto> findAll() {
        log.debug("finding all airports");
        return airportRepository.findAll();
    }

    public void update(Long airportId, AirportDto airportData){
        log.info("updating the airport with id = {}, using new data = {}", airportId, airportData);

        if (airportRepository.findById(airportId).isEmpty()) {
            throw new RuntimeException("user not found");
        }
        airportData.setId(airportId); // so we can use convertToEntity
        airportRepository.save(
                airportMapper.convertToEntity(airportData)
        );
    }
}
