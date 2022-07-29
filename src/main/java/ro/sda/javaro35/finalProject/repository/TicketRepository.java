package ro.sda.javaro35.finalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.javaro35.finalProject.dto.flight.TicketDto;
import ro.sda.javaro35.finalProject.entities.flight.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, Long> {


   List<Ticket> findTicketsByFromDestination(String fromDestination);
   List<Ticket> findAllTicketsByFlightCode(String flightCode);



   default Optional<Ticket> flightAlreadyExists(TicketDto dto) {
        // find all flights that have the same departure, destination and flightTime
        return findAll()
                .stream()
                .filter(
                        ticket -> ticket.getToDestination() == dto.getToDestination() &&
                                 ticket.getFromDestination() == dto.getFromDestination() &&
                                 ticket.getDeparture() == dto.getDeparture() &&
                                 ticket.getFlightTime() == dto.getFlightTime()
                ).findFirst();
    }
}

