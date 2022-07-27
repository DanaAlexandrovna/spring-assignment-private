package ro.sda.javaro35.finalProject.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ro.sda.javaro35.finalProject.dto.flight.FlightDto;
import ro.sda.javaro35.finalProject.entities.flight.Flight;
import ro.sda.javaro35.finalProject.repository.FlightRepository;

@Component
@Service
@Setter
@Getter
@AllArgsConstructor
public class FlightMapper {

    final FlightRepository flightRepository;

    public FlightDto convertToDto(Flight entity) {
        FlightDto result = new FlightDto();
        result.setId(entity.getId());
        result.setFromDestination(entity.getFromDestination());
        result.setToDestination(entity.getToDestination());
        result.setPrice(entity.getPrice());
        result.setQuantity(entity.getQuantity());
        result.setDeparture(entity.getDeparture());
        result.setFlightTime(entity.getFlightTime());
        result.setFlightCode(entity.getFlightCode());
        return result;
    }

    public Flight convertToEntity(FlightDto dto) {
        Flight flight = new Flight();
        flight.setFromDestination(dto.getFromDestination());
        flight.setToDestination(dto.getToDestination());
        flight.setPrice(dto.getPrice());
        flight.setQuantity(dto.getQuantity());
        flight.setDeparture(dto.getDeparture());
        flight.setFlightTime(dto.getFlightTime());
        flight.setFlightCode(dto.getFlightCode());
        return flight;
    }
}

