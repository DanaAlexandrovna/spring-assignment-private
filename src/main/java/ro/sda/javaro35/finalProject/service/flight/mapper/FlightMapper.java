package ro.sda.javaro35.finalProject.service.flight.mapper;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ro.sda.javaro35.finalProject.dto.flight.FlightDto;
import ro.sda.javaro35.finalProject.entities.flight.Flight;
import ro.sda.javaro35.finalProject.repository.FlightRepository;

@Component
@Service
@Data
public class FlightMapper {

    FlightRepository flightRepository;

    public FlightDto convertToDto(Flight entity) {
        FlightDto flightDto = new FlightDto();
        flightDto.setId(entity.getId());
        flightDto.setDeparture(entity.getDeparture());
        flightDto.setFlightTime(entity.getFlightTime());
        flightDto.setGate(entity.getGate());
        flightDto.setPrice(entity.getPrice());
        return flightDto;
    }

    public Flight convertToEntity(FlightDto dto) {
        Flight flight = null;
        if (dto.getId() != null) { // din baza de date aducem o entitate sa lucram cu ea
           flight = flightRepository.findById(dto.getId()).orElse(new Flight());
        } else { // altfel se va creea alta
            flight = new Flight();
        }
        flight.setId(dto.getId());
        flight.setDeparture(dto.getDeparture());
        flight.setFlightTime(dto.getFlightTime());
        flight.setGate(dto.getGate());
        flight.setPrice(dto.getPrice());
        return flight;
    }
}
