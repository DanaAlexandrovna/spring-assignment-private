package ro.sda.javaro35.finalProject.controller.registration;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import ro.sda.javaro35.finalProject.entities.user.User;
import ro.sda.javaro35.finalProject.entities.request.LoginRequest;
import ro.sda.javaro35.finalProject.service.user.LoginService;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class LogInController {
    private LoginService loginService;

//    Logger logger = LoggerFactory.getLogger(LogInController.class);
    @PostMapping( "/login")
    public User authenticate(@RequestBody LoginRequest request) {
//        logger.info("HELLO");
        System.out.println(request);
        User result = loginService.authenticate(request);
        return result;
    }
}