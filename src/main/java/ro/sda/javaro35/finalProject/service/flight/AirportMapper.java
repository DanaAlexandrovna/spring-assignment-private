package ro.sda.javaro35.finalProject.service.flight;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ro.sda.javaro35.finalProject.dto.flight.AirportDto;
import ro.sda.javaro35.finalProject.entities.flight.Airport;
import ro.sda.javaro35.finalProject.repository.AirportRepository;

@Component
@Service
@Setter
@Getter
@AllArgsConstructor
public class AirportMapper {

    final AirportRepository airportrepository;


    public AirportDto convertToDto(Airport entity){
        AirportDto airportDto = new AirportDto();
        airportDto.setId(entity.getId());
        airportDto.setName(entity.getName());
        airportDto.setGate(entity.getGate());
        return airportDto;
    }

    public AirportDto convertToEntity(AirportDto dto){
        Airport airport = null;
        if (dto.getId() != null) { // din baza de date aducem o entitate sa lucram cu ea
            airport = airportrepository.findById(dto.getId()).orElse(new Airport());
        } else { // altfel se va creea alta
            airport = new Airport();
        }
        airport.setId(dto.getId());
        airport.setName(dto.getName());
        airport.setGate(dto.getGate());
        return airport;
    }
}
