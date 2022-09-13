package ro.sda.javaro35.finalProject.service.flight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.javaro35.finalProject.entities.flight.Airport;
import ro.sda.javaro35.finalProject.exceptions.CantBeFoundException;
import ro.sda.javaro35.finalProject.repository.AirportRepository;

import java.util.List;


@Service
public class AirportService {
    private final AirportRepository airportRepository;

    @Autowired
    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public Airport addAirport(Airport airport) {
        airport.setName(airport.getName());
        return airportRepository.save(airport);
    }

    public List<Airport> findAllAirports() {
        return airportRepository.findAll();
    }

    public Airport findById(Long id) {
        return airportRepository.findById(id)
                .orElseThrow(() -> new CantBeFoundException("Airport by id" + id + "cannot be found"));
    }

    public Airport updateAirport(Airport update) {
        return airportRepository.save(update);
    }

    public void deleteAirport(Long id) {
        airportRepository.deleteById(id);
    }
}
