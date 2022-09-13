package ro.sda.javaro35.finalProject.service.user;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ro.sda.javaro35.finalProject.service.user.appuser.registration.token.ConfirmationTokenService;
import ro.sda.javaro35.finalProject.entities.user.User;
import ro.sda.javaro35.finalProject.repository.UserRepository;
import ro.sda.javaro35.finalProject.service.user.appuser.request.LoginRequest;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private static final String USER_NOT_FOUND_MSG =
            "user with email %s not found";
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;
    ConfirmationTokenService confirmationTokenService;


    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return (UserDetails) userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                String.format(USER_NOT_FOUND_MSG, email)));
    }

    public User authenticate(LoginRequest request) {
        if (request != null) {
            User appUser = userRepository.authenticate(request.getEmail());
            if (appUser != null) {
                if (passwordEncoder.matches(request.getPassword(), appUser.getPassword())) {
                    appUser.setPassword(null);
                    return appUser;
                }
            }
        }
        return null;
    }



    public int enableAppUser(String email) {
        return userRepository.enableAppUser(email);
    }
}