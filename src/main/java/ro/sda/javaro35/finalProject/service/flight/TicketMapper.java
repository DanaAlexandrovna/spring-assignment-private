package ro.sda.javaro35.finalProject.service.flight;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ro.sda.javaro35.finalProject.dto.flight.TicketDto;
import ro.sda.javaro35.finalProject.entities.flight.Ticket;
import ro.sda.javaro35.finalProject.repository.TicketRepository;

@Component
@Service
@Setter
@Getter
@AllArgsConstructor
public class TicketMapper {

    final TicketRepository ticketRepository;

    public TicketDto convertToDto(Ticket entity) {
        TicketDto result = new TicketDto();
        result.setId(entity.getId());
        result.setFromDestination(entity.getFromDestination());
        result.setToDestination(entity.getToDestination());
        result.setPrice(entity.getPrice());
        result.setQuantity(entity.getQuantity());
        result.setDeparture(entity.getDeparture());
        result.setFlightTime(entity.getFlightTime());
        result.setFlightCode(entity.getFlightCode());
        return result;
    }

    public Ticket convertToEntity(TicketDto dto) {
        Ticket ticket = new Ticket();
        ticket.setFromDestination(dto.getFromDestination());
        ticket.setToDestination(dto.getToDestination());
        ticket.setPrice(dto.getPrice());
        ticket.setQuantity(dto.getQuantity());
        ticket.setDeparture(dto.getDeparture());
        ticket.setFlightTime(dto.getFlightTime());
        ticket.setFlightCode(dto.getFlightCode());
        return ticket;
    }
}

