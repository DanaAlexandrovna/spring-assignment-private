package ro.sda.javaro35.finalProject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.sda.javaro35.finalProject.entities.flight.Aircraft;
import ro.sda.javaro35.finalProject.entities.flight.Ticket;
import ro.sda.javaro35.finalProject.service.flight.AircraftService;

@RestController
public class AircraftController {

    private final AircraftService aircraftService;

    public AircraftController(AircraftService aircraftService) {
        this.aircraftService = aircraftService;
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Aircraft> findById(@PathVariable("id") Long id) {
        Aircraft aircraft = aircraftService.findById(id);
        return new ResponseEntity<>(aircraft, HttpStatus.OK);
    }


// here it does not work with 2* CREATED
//    @PostMapping("/seat")
//    public ResponseEntity<Aircraft> saveSeat(@RequestBody Aircraft aircraft){
//        Aircraft saveSeat = aircraftService.saveSeat(aircraft);
//        return new ResponseEntity<>(saveSeat, HttpStatus.CREATED);
//    }

    @PostMapping("/add")
    public ResponseEntity<Aircraft> addAircraft(@RequestBody Aircraft aircraft){
        Aircraft addAircraft = aircraftService.addAircraft(aircraft);
        return new ResponseEntity<>(addAircraft, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Aircraft> updateAircraft(@RequestBody Aircraft aircraft){
        Aircraft updateAircraft = aircraftService.updateAircraft(aircraft);
        return new ResponseEntity<>(updateAircraft, HttpStatus.OK);
    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> deleteAircraft(@PathVariable("id") Long id){
        aircraftService.deleteAircraft(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
