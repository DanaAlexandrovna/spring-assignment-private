package ro.sda.javaro35.finalProject.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ro.sda.javaro35.finalProject.service.user.appuser.AppUser;
import ro.sda.javaro35.finalProject.service.user.appuser.AppUserService;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
@CrossOrigin(origins = "http://localhost:4200")
public class AppUserController {

    private final AppUserService appUserService;

    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @GetMapping("/all")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<AppUser>> all() {
        List<AppUser> users = appUserService.all();
        return new ResponseEntity<List<AppUser>>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<AppUser> findById(@PathVariable("id") Long id) {
        AppUser address = appUserService.findById(id);
        return new ResponseEntity<>(address, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<AppUser> addAddress(@RequestBody AppUser address) {
        AppUser addAddress = appUserService.add(address);
        return new ResponseEntity<>(addAddress, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<AppUser> updateTicket(@RequestBody AppUser address){
        AppUser updateAddress = appUserService.update(address);
        return new ResponseEntity<>(updateAddress, HttpStatus.OK);
    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> deleteAddress(@PathVariable("id") Long id){
        appUserService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}