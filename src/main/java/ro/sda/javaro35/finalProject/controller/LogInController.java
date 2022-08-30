package ro.sda.javaro35.finalProject.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.sda.javaro35.finalProject.entities.user.User;
import ro.sda.javaro35.finalProject.entities.request.LoginRequest;
import ro.sda.javaro35.finalProject.service.user.LoginService;
import ro.sda.javaro35.finalProject.service.user.UserService;

@RestController
@RequestMapping(path = "api/v1/login")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:8080")
public class LogInController {

    private UserService userService;

    private LoginService loginService;

    @PostMapping
    public User authenticate(@RequestBody LoginRequest request) {
        User result = loginService.authenticate(request);
        return result;
    }
}