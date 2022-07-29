package ro.sda.javaro35.finalProject.service.flight;

import ro.sda.javaro35.finalProject.dto.flight.AircraftDto;
import ro.sda.javaro35.finalProject.dto.flight.AirportDto;
import ro.sda.javaro35.finalProject.dto.user.UserDto;
import ro.sda.javaro35.finalProject.entities.flight.Aircraft;
import ro.sda.javaro35.finalProject.entities.user.User;
import ro.sda.javaro35.finalProject.repository.AircraftRepository;

public class AircraftMapper {

    AircraftRepository aircraftRepository;

    public AircraftDto convertToDto(Aircraft entity) {
        AircraftDto aircraftDto = new AircraftDto();
        aircraftDto.setId(entity.getId());
        aircraftDto.setAirlineCompany(entity.getAirlineCompany());
        aircraftDto.setSeats(entity.getSeats());
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
        aircraft.setAirlineCompany(dto.getAirlineCompany());
        aircraft.setSeats(dto.getSeats());
        return aircraft;
    }
}
