//package ro.sda.javaro35.finalProject.services.RESTservice;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ro.sda.javaro35.finalProject.entities.user.User;
import ro.sda.javaro35.finalProject.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

//@Service
//@RequiredArgsConstructor
//@FieldDefaults(level = PRIVATE, makeFinal = true)
//public class UserService implements UserDetailsService {
//    private static final Logger log = LoggerFactory.getLogger(UserService.class);
//
//    private final UserRepository userRepository;
//
//    @Autowired
//    private Password password;

//    @Autowired
//    public UserService(UserRepository userRepository)
//    {this.userRepository = userRepository;}
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        User user = userRepository.findByEmailIgnoreCase(email);
//        if(user == null){
//            throw new UsernameNotFoundException("Invalid username or password");
//        }
//        List positions = new ArrayList();
//        String position = "POSITION_" + user.getPosition();
//        position.add(new SimpleGrantedAuthority(position));
//        return new org.springframework.security.core.userdetails.User(user.getEmail()),
//        user.getPassword(), position);
//    }
//
//    public void save(User user){
//        log.info("saving user{}", user.getName());
//        user.setPassword(password.encode);
//    }
}
