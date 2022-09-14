package ro.sda.javaro35.finalProject.controller.user;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.sda.javaro35.finalProject.entities.user.User;
import ro.sda.javaro35.finalProject.service.user.appuser.AppUser;
import ro.sda.javaro35.finalProject.service.user.appuser.request.LoginRequest;
import ro.sda.javaro35.finalProject.service.user.LoginService;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class LogInController {
    private LoginService loginService;

//    Logger logger = LoggerFactory.getLogger(LogInController.class);
    @PostMapping( "/login")
    public AppUser authenticate(@RequestBody LoginRequest request) {
//        logger.info("HELLO");
        System.out.println(request);
        AppUser result = loginService.authenticate(request);
        return result;
    }
}