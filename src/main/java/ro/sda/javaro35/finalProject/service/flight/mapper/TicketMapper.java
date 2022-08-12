package ro.sda.javaro35.finalProject.service.flight.mapper;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ro.sda.javaro35.finalProject.dto.flight.TicketDto;
import ro.sda.javaro35.finalProject.entities.flight.Ticket;
import ro.sda.javaro35.finalProject.repository.FlightRepository;

@Component
@Service
@Data
public class TicketMapper {

    final FlightRepository ticketRepository;

    public TicketDto convertToDto(Ticket entity) {
        TicketDto result = new TicketDto();
        result.setId(entity.getId());
        return result;
    }

    public Ticket convertToEntity(TicketDto dto) {
        Ticket ticket = new Ticket();
        return ticket;
    }
}

