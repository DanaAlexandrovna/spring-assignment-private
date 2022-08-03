package ro.sda.javaro35.finalProject.service.flight.service;

import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.javaro35.finalProject.dto.flight.TicketDto;
import ro.sda.javaro35.finalProject.entities.flight.Ticket;
import ro.sda.javaro35.finalProject.exceptions.TicketCantBeFoundException;
import ro.sda.javaro35.finalProject.repository.TicketRepository;
import ro.sda.javaro35.finalProject.service.flight.mapper.TicketMapper;


import javax.validation.Valid;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Service
@Slf4j
@AllArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class TicketService {
    final TicketRepository ticketRepository;
    final TicketMapper ticketMapper;



    public TicketDto save(@Valid TicketDto form) {
        log.info("saving ticket = {}", form.getId());
        Ticket ticket = ticketMapper.convertToEntity(form);
        ticket = (Ticket) ticketRepository.save(ticket);
        return ticketMapper.convertToDto(ticket);
    }


    // find by id
    public TicketDto findById(long id){
            log.info("finding flight by id");
            Ticket entityTicket = (Ticket) ticketRepository.findById(id)
                    .orElseThrow(() -> new TicketCantBeFoundException("ticket not found"));
            return ticketMapper.convertToDto(entityTicket);
        }

//    // find by code ?
//    public List<TicketDto> findAllBy(){
//        log.info("finding by code");
//        return (TicketDto) ticketRepository.findAll().stream().map(flightCode-> ticketMapper.convertToDto(flightCode));
//                .orElseThrow(() -> new TicketCantBeFoundException("this flight can't be found"));
//    }


    // update
//    public void update(long id, TicketDto flightData){
//            Ticket flightData = new Ticket();
//            log.info("update flight with id = {}, using new data ={}", findById, flightData);
//
//            if (ticketRepository.findById(id).isEmpty()) {
//                throw new TicketCantBeFoundException("flight not found");
//            }
//
//            flightData.setId(flightId);
//            ticketRepository.save(ticketMapper.convertToEntity(flightData));
//        }

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
    @Transactional
    public void delete(Long id) {
        log.info("deleting by id");
        ticketRepository.deleteById(id);
    }

}

