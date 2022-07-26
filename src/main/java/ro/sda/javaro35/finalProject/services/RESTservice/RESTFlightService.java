package ro.sda.javaro35.finalProject.services.RESTservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.javaro35.finalProject.dto.flight.FlightMapper;
import ro.sda.javaro35.finalProject.dto.flight.FlightRequest;
import ro.sda.javaro35.finalProject.dto.flight.FlightResponse;
import ro.sda.javaro35.finalProject.entities.flight.Flight;
import ro.sda.javaro35.finalProject.exceptions.CantBeFoundException;
import ro.sda.javaro35.finalProject.exceptions.FlightCantBeFoundException;
import ro.sda.javaro35.finalProject.repository.FlightRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class RESTFlightService implements FlightService{

    private static final Logger log = LoggerFactory.getLogger(RESTFlightService.class);
    private final FlightRepository flightRepository;
    private final FlightMapper flightMapper;
    private final ObjectMapper jacksonObjectMapper;

    @Autowired
    public RESTFlightService(FlightRepository flightRepository, FlightMapper flightMapper, ObjectMapper jacksonObjectMapper){
        this.flightRepository = flightRepository;
        this.flightMapper = flightMapper;
        this.jacksonObjectMapper = jacksonObjectMapper;

    }

    @Override
    public List<FlightResponse> findAll() {
        log.debug("find all flights");

        return flightRepository.findAll().stream()
                .map(flightMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public FlightResponse findById(Long Id) {
        log.debug("find all by id: {}",id);

        return flightRepository.findById(id)
                .map(flightMapper::toDto)
                .orElseThrow(() -> new CantBeFoundException("product not found"));;
    }

    @Override
    public FlightResponse save(FlightRequest createFlightRequest) {
        log.debug("saving flight:{}", createFlightRequest);

        // If the two flights have the same from, to, and time
        boolean exists = flightRepository.flightAlreadyExists(createFlightRequest).isPresent();
        if(exists){
            throw new CantBeFoundException("duplicate product");
        }
        Flight flight = flightMapper.toEntity(createFlightRequest);
        Flight newFlight = flightRepository.save(flight);
        return flightMapper.toDto(newFlight);

    }

    @Override
    public FlightResponse update(String Id, FlightRequest updateRequest) {
        log.debug("updating flight with id: {} and request body :{}", id, updateRequest);

        return flightRepository.findById(Long.valueOf(id))
                .map(flight -> flightMapper.toEntity(flight, updateRequest))
                .map(flightRepository :: save)
                .map(flightMapper :: toDto)
                .orElseThrow(() -> new CantBeFoundException("flight can't be found"));

    }

    @Override
    public FlightResponse partialUpdate(Long Id, Map<String, Object> updates) {
       log.debug("patching product with id:{} and request body:{}",id,updates);
       try {
           Flight flight = flightRepository.findById(id)
                   .orElseThrow(() -> new CantBeFoundException("flight can't be found"));
           jacksonObjectMapper.readerForUpdating(flight)
                   .readValue(jacksonObjectMapper.writeValueAsBytes(updates));

           Flight updateFlight = flightRepository.save(flight);
           return flightMapper.toDto(updateFlight);
       }catch (Exception e){
           e.printStackTrace();
       }
       return null;
    }

    @Override
    public void delete(String id) {
        log.debug("deleting flight with id: {}",id);
        flightRepository.findById(id)
                .map(flight -> {
                    flightRepository.deleteById(id);
                    return flight;
                })
                .orElseThrow(() -> new CantBeFoundException("flight can't be found");

    }




}
