
package ro.sda.javaro35.finalProject.service.user.appuser.registration;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.sda.javaro35.finalProject.service.user.appuser.request.RegistrationRequest;
import ro.sda.javaro35.finalProject.service.user.RegistrationService;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping("/register")
    public String register(@RequestBody RegistrationRequest request) {
        String result = registrationService.register(request);
        return result;
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }
}
