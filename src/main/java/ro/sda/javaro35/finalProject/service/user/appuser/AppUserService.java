package ro.sda.javaro35.finalProject.service.user.appuser;



import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ro.sda.javaro35.finalProject.exceptions.CantBeFoundException;
import ro.sda.javaro35.finalProject.service.user.appuser.registration.token.ConfirmationToken;
import ro.sda.javaro35.finalProject.service.user.appuser.registration.token.ConfirmationTokenService;
import ro.sda.javaro35.finalProject.service.user.appuser.request.LoginRequest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG =
            "user with email %s not found";

    private final AppUserRepository appUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                String.format(USER_NOT_FOUND_MSG, email)));
    }

    public AppUser authenticate(LoginRequest request) {
        if (request != null) {
            AppUser appUser = appUserRepository.authenticate(request.getEmail());
            System.out.println(appUser);
            if (appUser != null) {
                if (bCryptPasswordEncoder.matches(request.getPassword(), appUser.getPassword())) {
                    appUser.setPassword(null);
                    return appUser;
                }
            }
        }
        return null;
    }

    public String signUpUser(AppUser appUser) {
        boolean userExists = appUserRepository
                .findByEmail(appUser.getEmail())
                .isPresent();

        if (userExists) {
            // TODO check of attributes are the same and
            // TODO if email not confirmed send confirmation email.

            throw new IllegalStateException("email already taken");
        }
        System.out.println(appUser.getEmail() + "==" + appUser.getPassword());
        String encodedPassword = bCryptPasswordEncoder
                .encode(appUser.getPassword());

        appUser.setPassword(encodedPassword);

        appUserRepository.save(appUser);

        String token = UUID.randomUUID().toString();

        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                appUser
        );

        confirmationTokenService.saveConfirmationToken(
                confirmationToken);

//        TODO: SEND EMAIL

        return token;
    }

    public int enableAppUser(String email) {
        return appUserRepository.enableAppUser(email);
    }


    // used as REST API:

    public List<AppUser> all() {
        return appUserRepository.findAll();
    }
    public AppUser add(AppUser appUser) {
        appUser.setAppUserRole(appUser.getAppUserRole());
        appUser.setId(appUser.getId());
        appUser.setPassword(appUser.getPassword());
        appUser.setEmail(appUser.getEmail());
        appUser.setEnabled(appUser.getEnabled());
        appUser.setFirstName(appUser.getFirstName());
        appUser.setLastName(appUser.getLastName());
        appUser.setLocked(appUser.getLocked());
        return appUser;
    }

    public AppUser findById(Long id) {
        return appUserRepository.findById(id).orElseThrow(() -> new CantBeFoundException("Address by id" + id + "cannot be found"));
    }

    public void delete(Long id) {
        appUserRepository.deleteById(id);
    }

    public AppUser update(AppUser update) {
        return appUserRepository.save(update);
    }

}
