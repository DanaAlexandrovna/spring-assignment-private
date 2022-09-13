package ro.sda.javaro35.finalProject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.sda.javaro35.finalProject.entities.flight.Airport;
import ro.sda.javaro35.finalProject.entities.flight.Ticket;
import ro.sda.javaro35.finalProject.service.flight.AirportService;

import java.util.List;

@RestController
@RequestMapping(path = "airports")
public class AirportController {

    private final AirportService airportService;

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Airport>> getAllAirports() {
        List<Airport> airports = airportService.findAllAirports();
        return new ResponseEntity<>(airports, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Airport> findById(@PathVariable("id") Long id) {
        Airport airport = airportService.findById(id);
        return new ResponseEntity<>(airport, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Airport> addAirport(@RequestBody Airport airport) {
        Airport addAirport = airportService.addAirport(airport);
        return new ResponseEntity<>(addAirport, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Airport> updateAirport(@RequestBody Airport airport) {
        Airport updateAirport = airportService.updateAirport(airport);
        return new ResponseEntity<>(updateAirport, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAirport(@PathVariable("id") Long id) {
        airportService.deleteAirport(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}