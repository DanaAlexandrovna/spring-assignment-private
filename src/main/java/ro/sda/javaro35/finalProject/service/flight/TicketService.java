package ro.sda.javaro35.finalProject.service.flight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.javaro35.finalProject.entities.flight.Ticket;
import ro.sda.javaro35.finalProject.exceptions.CantBeFoundException;
import ro.sda.javaro35.finalProject.repository.TicketRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class TicketService {
    final TicketRepository ticketRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }


    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    public Ticket addTicket(Ticket ticket) {
     //   ticket.setId(UUID.randomUUID().toString());
       ticket.setId(ticket.getId());
        return ticketRepository.save(ticket);
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
    public void deleteTicket(Long id) {
        ticketRepository.deleteTicketById(id);
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