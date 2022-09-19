package ro.sda.javaro35.finalProject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.sda.javaro35.finalProject.entities.flight.Flight;
import ro.sda.javaro35.finalProject.service.flight.FlightService;

import java.util.List;

@RestController
@RequestMapping(path = "/flights")
@CrossOrigin(origins = "http://localhost:4200")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Flight>> getAll() {
        List<Flight> aircrafts = flightService.all();
        return new ResponseEntity<>(aircrafts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flight> findById(@PathVariable("id") Long id) {
        Flight aircraft = flightService.findById(id);
        return new ResponseEntity<>(aircraft, HttpStatus.OK);
    }



// here it does not work with 2* CREATED
//    @PostMapping("/seat")
//    public ResponseEntity<Flight> saveSeat(@RequestBody Flight aircraft){
//        Flight saveSeat = aircraftService.saveSeat(aircraft);
//        return new ResponseEntity<>(saveSeat, HttpStatus.CREATED);
//    }

    @PostMapping("/add")
    public ResponseEntity<Flight> addFlight(@RequestBody Flight aircraft){
        Flight addFlight = flightService.addFlight(aircraft);
        return new ResponseEntity<>(addFlight, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Flight> updateFlight(@RequestBody Flight aircraft){
        Flight updateFlight = flightService.updateFlight(aircraft);
        return new ResponseEntity<>(updateFlight, HttpStatus.OK);
    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> deleteFlight(@PathVariable("id") Long id){
        flightService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
