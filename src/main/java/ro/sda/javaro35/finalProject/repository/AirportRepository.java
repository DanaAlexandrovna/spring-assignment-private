package ro.sda.javaro35.finalProject.repository;

import ro.sda.javaro35.finalProject.dto.flight.AirportDto;
import ro.sda.javaro35.finalProject.entities.flight.Airport;

import java.util.List;
import java.util.Optional;

public interface AirportRepository {
    Optional<Airport> findById(Long id);

    void save(AirportDto airport);

    List<AirportDto> findAll();

}
