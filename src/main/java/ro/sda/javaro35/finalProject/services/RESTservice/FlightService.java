package ro.sda.javaro35.finalProject.services.RESTservice;

import ro.sda.javaro35.finalProject.dto.flight.FlightRequest;
import ro.sda.javaro35.finalProject.dto.flight.FlightResponse;

import java.util.List;
import java.util.Map;

public interface FlightService {

    List<FlightResponse> findAll();
    FlightResponse findById(Long Id);
    FlightResponse save(FlightRequest createFlightRequest);
    FlightResponse update(Long Id, FlightRequest updateRequest);
    FlightResponse partialUpdate(Long Id, Map<String, Object> updates);
    void delete(Long id);

}
