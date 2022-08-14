package ro.sda.javaro35.finalProject.service.user;

import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.javaro35.finalProject.dto.user.UserDto;
import ro.sda.javaro35.finalProject.entities.user.User;
import ro.sda.javaro35.finalProject.exceptions.ThisAlreadyExistsException;
import ro.sda.javaro35.finalProject.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;
import static lombok.AccessLevel.PRIVATE;

@Service
@Slf4j
@AllArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class UserService implements UserDetailsService {
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmailIgnoreCase(email);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("Invalid email or password");
        }
        List<SimpleGrantedAuthority> roles = new ArrayList<>();
        String role = "ROLE_" + user.get().getRoles();
        roles.add(new SimpleGrantedAuthority(role));
        return new org.springframework.security.core.userdetails.User(user.get().getEmail(),
                user.get().getPassword(), roles);
    }

    //create
    public UserDto save(UserDto userForm) {
        log.info("saving user with email {}", userForm.getEmail());

        boolean emailAlreadyUsed = userRepository.findByEmailIgnoreCase(userForm.getEmail()).isPresent();
        if (emailAlreadyUsed) {
            throw new ThisAlreadyExistsException("User with email " + userForm.getEmail() + " already exists!");
        }

        userForm.setPassword(passwordEncoder.encode(userForm.getPassword()));
        User userEntity = userMapper.convertToEntity(userForm);
        if (userForm.getRoles() == null) {
            userForm.setRoles("USER");
        }
        userRepository.save(userEntity);
        return userForm;
    }

    //find all
    public List<UserDto> findAll() {
        log.debug("finding all users");
        return userRepository.findAll()
                .stream()
                .map(user -> userMapper.convertToDto(user))
                .collect(toList());
    }

    public User findById(Long id) {
        log.info("finding by id");
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("user not found"));
    }

    public void update(Long userId, UserDto userData) {
        log.info("update user with id={}, using new data={}", userId, userData);

        if (userRepository.findById(userId).isEmpty()) {
            throw new RuntimeException("user not found");
        }

        userData.setId(userId); // so we can use convertToEntity
        userRepository.save(
                userMapper.convertToEntity(userData)
        );

    }

        @Transactional
        public void delete(Long id) {
            log.info("deleting by id");
           userRepository.deleteById(id);
}

}

