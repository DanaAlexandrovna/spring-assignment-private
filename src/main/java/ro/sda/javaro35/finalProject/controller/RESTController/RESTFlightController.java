package ro.sda.javaro35.finalProject.controller.RESTController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.sda.javaro35.finalProject.dto.flight.FlightRequest;
import ro.sda.javaro35.finalProject.dto.flight.FlightResponse;
import ro.sda.javaro35.finalProject.services.service.FlightServices;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(RESTFlightController.API_FLIGHTS)
public class RESTFlightController {

    public static final String API_FLIGHTS = "/api/flights";

    private final FlightServices flightServices;

    //????? @SuppressWarnings
    @Autowired
    public RESTFlightController(@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection") FlightServices restFlightServices) {
        this.flightServices = restFlightServices;
    }

    @GetMapping("/")
    public ResponseEntity<List<FlightResponse>> findAll() {
        return ResponseEntity.ok(FlightServices.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlightResponse> findById(@PathVariable("id") String id) {
        return ResponseEntity.ok(flightServices.findById(id));
    }

    @PostMapping
    public ResponseEntity<FlightResponse> create(@Valid @RequestBody FlightRequest flightRequest){
    return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(flightServices.save(flightRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FlightResponse> update(
            @PathVariable("id") Long id,
            @RequestBody FlightRequest flightRequest) {
        return ResponseEntity.ok(flightServices.update(id, flightRequest));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<FlightResponse> partialUpdate(
            @PathVariable("id") Long id,
            @RequestBody Map<String, Object> flightRequest) {
        return ResponseEntity.ok(flightServices.partialUpdate(id, flightRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String) {
        flightServices.delete(id);
        return ResponseEntity.noContent().build();
    }
}