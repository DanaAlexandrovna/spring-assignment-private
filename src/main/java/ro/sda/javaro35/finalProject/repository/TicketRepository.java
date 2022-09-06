package ro.sda.javaro35.finalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.javaro35.finalProject.entities.flight.Ticket;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

}