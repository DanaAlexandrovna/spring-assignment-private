
package ro.sda.javaro35.finalProject.service.flight.service;

import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.javaro35.finalProject.dto.flight.AirportDto;
import ro.sda.javaro35.finalProject.entities.flight.Airport;
import ro.sda.javaro35.finalProject.entities.flight.Ticket;
import ro.sda.javaro35.finalProject.repository.AirportRepository;
import ro.sda.javaro35.finalProject.service.flight.mapper.AirportMapper;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static lombok.AccessLevel.PRIVATE;

@Service
@Slf4j
@AllArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class AirportService {

    final AirportRepository airportRepository;

    AirportMapper airportMapper;

    //save
    public AirportDto save(AirportDto form){
        log.info("saving the airport = {}", form.getName());
        Airport airport = airportMapper.convertToEntity(form);
        airport = airportRepository.save(airport);
        return airportMapper.convertToDto(airport);

    }

    public List<AirportDto> findAll() {
        log.debug("finding all airports");
        return airportRepository.findAll()
        .stream()
                .map(airport -> airportMapper.convertToDto(airport))
                .collect(toList());
    }

    public void update(Long airportId, AirportDto airportData){
        log.info("updating the airport with id = {}, using new data = {}", airportId, airportData);

        if (airportRepository.findById(airportId).isEmpty()) {
            throw new RuntimeException("airport not found");
        }
        airportData.setId(airportId); // so we can use convertToEntity
        airportRepository.save(airportMapper.convertToEntity(airportData));
    }

    @Transactional
    public void delete(Long id) {
        log.info("deleting by id");
        airportRepository.deleteById(id);
    }
}
