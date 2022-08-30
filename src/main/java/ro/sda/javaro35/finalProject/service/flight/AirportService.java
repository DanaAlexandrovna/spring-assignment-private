package ro.sda.javaro35.finalProject.service.flight;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.javaro35.finalProject.entities.flight.Airport;
import ro.sda.javaro35.finalProject.exceptions.CantBeFoundException;
import ro.sda.javaro35.finalProject.repository.AirportRepository;

import java.util.List;


@Service
@Transactional
@AllArgsConstructor
public class AirportService {

    private final AirportRepository airportRepository;


    //save
    public Airport addAirport(Airport airport) {
        airport.setName(airport.getName());
        return airportRepository.save(airport);
    }

    //read all ???
    public Page<Airport> findAllAirports(Pageable pageable) {
        Page<Airport> result = airportRepository.findAll(pageable);
        return result;
    }

    public List<Airport> findAll(Airport list) {
        List<Airport> airportList = airportRepository.findAll();
        return airportList;
    }

    //find one
    public Airport findById(Long id) {
        return airportRepository.findById(id).orElseThrow(() -> new CantBeFoundException("Airport by id" + id + "cannot be found"));
    }

    public Airport updateAirport(Airport update) {
        return airportRepository.save(update);
    }

    public void delete(Long id) {
        airportRepository.deleteById(id);
    }
}
