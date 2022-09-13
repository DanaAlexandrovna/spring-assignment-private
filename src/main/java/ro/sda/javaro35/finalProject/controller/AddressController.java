package ro.sda.javaro35.finalProject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.sda.javaro35.finalProject.entities.flight.Address;
import ro.sda.javaro35.finalProject.entities.flight.Ticket;
import ro.sda.javaro35.finalProject.service.flight.AddressService;

@RestController
@RequestMapping(path = "addresses")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Address> findById(@PathVariable("id") Long id) {
        Address address = addressService.findById(id);
        return new ResponseEntity<>(address, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Address> addAddress(@RequestBody Address address) {
        Address addAddress = addressService.addAddress(address);
        return new ResponseEntity<>(addAddress, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Address> updateTicket(@RequestBody Address address){
        Address updateAddress = addressService.updateAddress(address);
        return new ResponseEntity<>(updateAddress, HttpStatus.OK);
    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> deleteAddress(@PathVariable("id") Long id){
        addressService.deleteAddress(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}