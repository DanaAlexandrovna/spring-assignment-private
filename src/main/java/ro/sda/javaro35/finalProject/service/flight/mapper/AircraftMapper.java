package ro.sda.javaro35.finalProject.service.flight.mapper;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ro.sda.javaro35.finalProject.dto.flight.AircraftDto;
import ro.sda.javaro35.finalProject.entities.flight.Aircraft;
import ro.sda.javaro35.finalProject.repository.AircraftRepository;

@Component
@Service
@Data
public class AircraftMapper {

    AircraftRepository aircraftRepository;

    public AircraftDto convertToDto(Aircraft entity) {
        AircraftDto aircraftDto = new AircraftDto();
        aircraftDto.setId(entity.getId());
        aircraftDto.setMake(entity.getMake());
        aircraftDto.setNumberOfSeats(entity.getNumberOfSeats());
        return aircraftDto;
    }

    public Aircraft convertToEntity(AircraftDto dto) {
        Aircraft aircraft = null;
        if (dto.getId() != null) { // din baza de date aducem o entitate sa lucram cu ea
            aircraft = aircraftRepository.findById(dto.getId()).orElse(new Aircraft());
        } else { // altfel se va creea alta
            aircraft = new Aircraft();
        }
        aircraft.setId(dto.getId());
        aircraft.setMake(dto.getMake());
        aircraft.setNumberOfSeats(dto.getNumberOfSeats());
        return aircraft;
    }
}
