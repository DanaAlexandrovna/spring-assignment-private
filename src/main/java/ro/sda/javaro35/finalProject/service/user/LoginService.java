package ro.sda.javaro35.finalProject.service.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ro.sda.javaro35.finalProject.service.user.appuser.AppUser;
import ro.sda.javaro35.finalProject.service.user.appuser.AppUserService;
import ro.sda.javaro35.finalProject.service.user.appuser.request.LoginRequest;

@Service
@AllArgsConstructor
public class LoginService {
    private final AppUserService appUserService;

    public AppUser authenticate(LoginRequest request) {
        return appUserService.authenticate(request);
    }
}
