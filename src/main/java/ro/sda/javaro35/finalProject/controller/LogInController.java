package ro.sda.javaro35.finalProject.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.sda.javaro35.finalProject.entities.user.User;
import ro.sda.javaro35.finalProject.entities.request.LoginRequest;
import ro.sda.javaro35.finalProject.service.user.LoginService;

@RestController
@RequestMapping(path = "/login")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class LogInController {
    private LoginService loginService;

    @PostMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public User authenticate(@RequestBody LoginRequest request) {
        User result = loginService.authenticate(request);
        return result;
    }
}