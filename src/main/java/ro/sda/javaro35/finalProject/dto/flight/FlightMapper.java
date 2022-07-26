package ro.sda.javaro35.finalProject.dto.flight;

import org.springframework.stereotype.Component;
import ro.sda.javaro35.finalProject.entities.flight.Flight;

@Component
public class FlightMapper {

    public FlightResponse toDto(Flight flight){
        FlightResponse dto = new FlightResponse();
        dto.setId(flight.getId());
        dto.setFromDestination(flight.getFromDestination());
        dto.setToDestination(flight.getToDestination());
        dto.setPrice(flight.getPrice());
        dto.setQuantity(flight.getQuantity());
        dto.setDeparture(flight.getDeparture());
        dto.setFlightTime(flight.getFlightTime());
        dto.setFlightCode(flight.getFlightCode());
        return dto;
    }

    public Flight toEntity(FlightRequest flightRequest){
        Flight flight = new Flight();
        flight.setFromDestination(flightRequest.getFromDestination());
        flight.setToDestination(flightRequest.getToDestination());
        flight.setPrice(flightRequest.getPrice());
        flight.setQuantity(flightRequest.getQuantity());
        flight.setDeparture(flightRequest.getDeparture());
        flight.setFlightTime(flightRequest.getFlightTime());
        flight.setFlightCode(flightRequest.getFlightCode());
        return flight;
    }
    public Flight toEntity(Flight flight, FlightRequest flightRequest){
        flight.setFromDestination(flightRequest.getFromDestination());
        flight.setToDestination(flightRequest.getToDestination());
        flight.setPrice(flightRequest.getPrice());
        flight.setQuantity(flightRequest.getQuantity());
        flight.setDeparture(flightRequest.getDeparture());
        flight.setFlightTime(flightRequest.getFlightTime());
        flight.setFlightCode(flightRequest.getFlightCode());
        return flight;
    }

//    public Flight toEntity(Flight flightUpdate, FlightRequest, updateRequest){
//        if(!StringUtils.isEmpty(update))
//    }

}
