package ro.sda.javaro35.finalProject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.sda.javaro35.finalProject.dto.flight.FlightDto;
import ro.sda.javaro35.finalProject.service.FlightService;

import java.util.List;

import static ro.sda.javaro35.finalProject.controller.FlightController.BASE_URL;

@RestController
@RequiredArgsConstructor
@RequestMapping(BASE_URL)
public class FlightController {

    static final String BASE_URL = "/api/flights";
    private final FlightService flightService;

    @GetMapping(path = "/fromDestination")
    public List<FlightDto> getAllByFromDestination(@PathVariable String)

}
