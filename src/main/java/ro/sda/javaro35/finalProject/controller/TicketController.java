package ro.sda.javaro35.finalProject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.sda.javaro35.finalProject.entities.flight.Aircraft;
import ro.sda.javaro35.finalProject.entities.flight.Flight;
import ro.sda.javaro35.finalProject.entities.flight.Ticket;
import ro.sda.javaro35.finalProject.service.flight.AircraftService;
import ro.sda.javaro35.finalProject.service.flight.FlightService;
import ro.sda.javaro35.finalProject.service.flight.TicketService;
import ro.sda.javaro35.finalProject.service.user.appuser.AppUser;
import ro.sda.javaro35.finalProject.service.user.appuser.AppUserRepository;
import ro.sda.javaro35.finalProject.service.user.appuser.AppUserService;

import java.util.List;

@RestController
@RequestMapping(path = "/tickets")
@CrossOrigin(origins = "http://localhost:4200")
public class TicketController {
    private final TicketService ticketService;
    private final AppUserService appUserService;
    private final FlightService flightService;
    private final AircraftService aircraftService;

    public TicketController(TicketService ticketService,
                            AppUserService appUserService,
                            FlightService flightService,
                            AircraftService aircraftService) {
        this.ticketService = ticketService;
        this.appUserService = appUserService;
        this.flightService = flightService;
        this.aircraftService = aircraftService;
    }


    @GetMapping("/all")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> getAllTickets() {
        List<Ticket> tickets = ticketService.findAll();
        return new ResponseEntity<List<Ticket>>(tickets, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> findById(@PathVariable("id") Long id) {
        Ticket ticket = ticketService.findById(id);
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }

    @PostMapping("/add/{user_id}/{aircraft_id}/{flight_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Ticket> addTicket(@PathVariable("user_id") Long user_id,
                                            @PathVariable("aircraft_id") Long aircraft_id,
                                            @PathVariable("flight_id") Long flight_id) {
        AppUser user = appUserService.findById(user_id);
        Aircraft aircraft = aircraftService.findById(aircraft_id);
        Flight flight = flightService.findById(flight_id);

        Ticket addTicket = new Ticket();

        addTicket.setUser(user);
        addTicket.setAircraft(aircraft);
        addTicket.setFlight(flight);

        addTicket = ticketService.addTicket(addTicket);

        return new ResponseEntity<>(addTicket, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Ticket> updateTicket(@RequestBody Ticket ticket) {
        Ticket updateTicket = ticketService.updateTicket(ticket);
        return new ResponseEntity<>(updateTicket, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> deleteTicket(@PathVariable("id") Long id) {
        ticketService.deleteTicket(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}