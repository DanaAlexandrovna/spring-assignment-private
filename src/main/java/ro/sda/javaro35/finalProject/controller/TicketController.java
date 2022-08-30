package ro.sda.javaro35.finalProject.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.sda.javaro35.finalProject.entities.flight.Ticket;
import ro.sda.javaro35.finalProject.service.flight.TicketService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("ticket")      //    /books/
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET})
public class TicketController {
    private final TicketService ticketService;

    @GetMapping
    @CrossOrigin(origins = "http://localhost:4200")
    List<Ticket> readAll() {
        return ticketService.findAll();
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Ticket> getBookById(@PathVariable("id") Long id) {
        Ticket ticket = ticketService.findById(id);
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }

}
