package ro.sda.javaro35.finalProject.service.flight;

import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ro.sda.javaro35.finalProject.dto.flight.TicketDto;
import ro.sda.javaro35.finalProject.entities.flight.Ticket;
import ro.sda.javaro35.finalProject.repository.TicketRepository;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Service
@Slf4j
@AllArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class TicketService {
    final TicketRepository ticketRepository;
    ModelMapper modelMapper;
    final TicketMapper ticketMapper;

    //cthis has to be created : fromDestination + toDestination
//    public void save(@Valid Flight flight) {
//        log.info("saving flight {}", flight.getId());
//        flightRepository.save(flight);
//    }

//    public void save(Ticket ticketR){
//        log.info("saving flight from = {}, to = {}",
//                ticketR.getFromDestination(), ticketR.getToDestination());
//        boolean flightAlreadyExists = ticketRepository.flightAlreadyExists(ticketR.getFlightCode().isEmpty());
//    }


    // find all ?
    public List<Ticket> findTicketByFromDestination(Ticket ticket) {
        log.info("finding all flights");
        return ticketRepository.findTicketsByFromDestination(ticket.getFromDestination());
    }

    // find by code ?
    public Ticket findAllByFlightCode(String flightCode) {
        log.info("finding by code");
        return (Ticket) ticketRepository.findAllTicketsByFlightCode(flightCode);
//                .orElseThrow(() -> new FlightCantBeFoundException("this flight can't be found"));
    }


    // update
    public void update(Long flightId, TicketDto flightData) {
        log.info("update flight with id = {}, using new data ={}", flightId, flightData);

        if (ticketRepository.findById(flightId).isEmpty()) {
            throw new RuntimeException("flight not found");
        }

        flightData.setId(flightId);
        ticketRepository.save(ticketMapper.convertToEntity(flightData));


//        Flight Flight = new Flight();
//        flightRepository.findById(flightId)
//                .map(existingFlight -> updateEntity(flightData, existingFlight))
//                .map(updatedProduct -> flightRepository.save(Flight))
//                .orElseThrow(() -> new CantBeFoundException("flight not found"));
//    }

//    TODO ERROR, if the partialUpdate() is still necessary
//    public partialUpdate( ) {
//        log.info("update flight {}", Flight);
//        flightDto.flightAlreadyExists(FlightRepository dto)
//                .filter(existingProduct -> existingProduct.getId().equals(dto.getId()))
//                .map(existingProduct -> flightDto.save(dto))
//                .orElseThrow(() -> {
//                    log.error("product with id {} already exists", id);
//                    throw new ThisAlreadyExistsException("flight with " + id + " already exists");
//                });
//    }

        // delete
//    @Transactional
//    public void delete(Long id) {
//        log.info("deleting by id");
//        ticketRepository.deleteById(id);
//    }
    }
}

