//package ro.sda.javaro35.finalProject.service.user;
//
//import lombok.AllArgsConstructor;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import ro.sda.javaro35.finalProject.service.user.appuser.AppUser;
//import ro.sda.javaro35.finalProject.service.user.appuser.AppUserRepository;
//import ro.sda.javaro35.finalProject.service.user.appuser.registration.token.ConfirmationTokenService;
//import ro.sda.javaro35.finalProject.entities.user.User;
//import ro.sda.javaro35.finalProject.repository.UserRepository;
//import ro.sda.javaro35.finalProject.service.user.appuser.request.LoginRequest;
//
//import java.util.Optional;
//
//@Service
//@AllArgsConstructor
//public class UserService implements UserDetailsService {
//
//    private static final String USER_NOT_FOUND_MSG =
//            "user with email %s not found";
//    AppUserRepository appUserRepository;
//    PasswordEncoder passwordEncoder;
//    ConfirmationTokenService confirmationTokenService;
//
//
//    @Override
//    public UserDetails loadUserByUsername(String email)
//            throws UsernameNotFoundException {
//        return (UserDetails) appUserRepository.findByEmail(email)
//                .orElseThrow(() ->
//                        new UsernameNotFoundException(
//                                String.format(USER_NOT_FOUND_MSG, email)));
//    }
//
//    public AppUser authenticate(LoginRequest request) {
//        if (request != null) {
//            Optional<AppUser> appUser = appUserRepository.findByEmail(request.getEmail());
//            if (appUser.isPresent()) {
//                AppUser user = appUser.get();
//                if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
//                    user.setPassword(null);
//                    return user;
//                }
//            }
//        }
//        return null;
//    }
//
//
//    public int enableAppUser(String email) {
//        return appUserRepository.enableAppUser(email);
//    }
//}