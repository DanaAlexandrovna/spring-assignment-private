package ro.sda.javaro35.finalProject.service.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ro.sda.javaro35.finalProject.entities.user.User;
import ro.sda.javaro35.finalProject.entities.request.LoginRequest;

@Service
@AllArgsConstructor
public class LoginService {
    private final UserService appUserService;

    public User authenticate(LoginRequest request) {
        User appUser = appUserService.authenticate(request);
        return appUser;
    }
}
