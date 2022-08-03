package ro.sda.javaro35.finalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.javaro35.finalProject.entities.flight.Address;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
