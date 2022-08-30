package ro.sda.javaro35.finalProject.service.flight;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.javaro35.finalProject.entities.flight.Address;
import ro.sda.javaro35.finalProject.entities.flight.Ticket;
import ro.sda.javaro35.finalProject.exceptions.CantBeFoundException;
import ro.sda.javaro35.finalProject.repository.AddressRepository;


@Service
@Transactional
@AllArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;

    public Address addAddress(Address address) {
        address.setAddress(address.getAddress());
        address.setCountry(address.getCountry());
        return address;
    }

    public Address findById(Long id) {
        return addressRepository.findById(id).orElseThrow(() -> new CantBeFoundException("Address by id" + id + "cannot be found"));
    }

    public void delete(Long id) {
        addressRepository.deleteById(id);
    }

    public Address updateAddress(Address update) {
        return addressRepository.save(update);
    }
}