package ro.sda.javaro35.finalProject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.sda.javaro35.finalProject.service.flight.service.TicketService;

import static ro.sda.javaro35.finalProject.controller.FlightController.BASE_URL;

@RestController
@RequiredArgsConstructor
@RequestMapping(BASE_URL)
public class FlightController {

    static final String BASE_URL = "/api/flights";
    private final TicketService ticketService;

    // TODO ERROR
//    @GetMapping(path = "/fromDestination")
//    public List<FlightDto> getAllByFromDestination(@PathVariable String)

}
