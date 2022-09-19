package ro.sda.javaro35.finalProject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.sda.javaro35.finalProject.entities.flight.Ticket;
import ro.sda.javaro35.finalProject.service.flight.TicketService;

import java.util.List;

@RestController
@RequestMapping(path = "/tickets")
@CrossOrigin(origins = "http://localhost:4200")
public class TicketController {
    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<Ticket>> getAllTickets(){
        List<Ticket> tickets = ticketService.findAll();
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> findById(@PathVariable("id") Long id) {
        Ticket ticket = ticketService.findById(id);
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Ticket> addTicket(@RequestBody Ticket ticket){
        Ticket addTicket = ticketService.addTicket(ticket);
        return new ResponseEntity<>(addTicket, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Ticket> updateTicket(@RequestBody Ticket ticket){
        Ticket updateTicket = ticketService.updateTicket(ticket);
        return new ResponseEntity<>(updateTicket, HttpStatus.OK);
    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> deleteTicket(@PathVariable("id") Long id){
        ticketService.deleteTicket(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}