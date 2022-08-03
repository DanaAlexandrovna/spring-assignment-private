package ro.sda.javaro35.finalProject.service.flight.mapper;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ro.sda.javaro35.finalProject.dto.flight.AddressDto;
import ro.sda.javaro35.finalProject.entities.flight.Address;
import ro.sda.javaro35.finalProject.repository.AddressRepository;

@Component
@Service
@Data
public class AddressMapper {

    AddressRepository addressRepository;

    public AddressDto convertToDto(Address entity) {
        AddressDto addressDto = new AddressDto();
        addressDto.setId(entity.getId());
        addressDto.setCountry(entity.getCountry());
        addressDto.setAddress(entity.getAddress());
        return addressDto;
    }

    public Address convertToEntity(AddressDto dto) {
        Address address = null;
        if (dto.getId() != null) { // din baza de date aducem o entitate sa lucram cu ea
            address = addressRepository.findById(dto.getId()).orElse(new Address());
        } else { // altfel se va creea alta
            address = new Address();
        }
        address.setId(dto.getId());
        address.setCountry(dto.getCountry());
        address.setAddress(dto.getAddress());
        return address;
    }
}
