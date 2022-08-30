package ro.sda.javaro35.finalProject.service.flight;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.javaro35.finalProject.entities.flight.Ticket;
import ro.sda.javaro35.finalProject.exceptions.CantBeFoundException;
import ro.sda.javaro35.finalProject.repository.TicketRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Transactional
@AllArgsConstructor
public class TicketService {
    final TicketRepository ticketRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public Ticket addTicket(Ticket ticket) {
        ticket.setId(ticket.getId());
        return ticket;
    }

    public Ticket findById(Long id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new CantBeFoundException("Ticket by id" + id + "cannot be found"));
    }

    //update

    public Ticket updateTicket(Ticket update) {
        return ticketRepository.save(update);
    }

    // delete
    public void delete(Long id) {
        ticketRepository.deleteById(id);
    }

//    public List<Ticket> findAvailableTickets() {
//        return entityManager.createQuery("SELECT p FROM Ticket p WHERE p.available is true",
//                Ticket.class).getResultList();
//    }

//    public List<Ticket> findUnavailableTickets() {
//        return entityManager.createQuery("SELECT p FROM Ticket p WHERE p.available is false",
//                Ticket.class).getResultList();
//    }

}