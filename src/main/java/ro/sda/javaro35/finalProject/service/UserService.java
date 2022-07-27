package ro.sda.javaro35.finalProject.service;

import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.javaro35.finalProject.dto.user.UserDto;
import ro.sda.javaro35.finalProject.entities.user.User;
import ro.sda.javaro35.finalProject.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static lombok.AccessLevel.PRIVATE;

@Service
@Slf4j
@AllArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class UserService implements UserDetailsService {
    final UserRepository userRepository;

    PasswordEncoder passwordEncoder;

    ModelMapper modelMapper;

    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmailIgnoreCase(email);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid email or password");
        }
        List roles = new ArrayList();
        String role = "ROLE_" + user.getRoles();
        roles.add(new SimpleGrantedAuthority(role));
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(), roles);
    }

    //create
    public void save(UserDto userForm) {
        log.info("saving user {}", userForm.getName());
        userForm.setPassword(passwordEncoder.encode(userForm.getPassword()));
        User userEntity = modelMapper.map(userForm, User.class);
        if (userForm.getRoles() == null) {
            userForm.setRoles("USER");
        }
        userRepository.save(userEntity);
    }

    //find all
    public List<UserDto> getAll() {
        log.debug("fetching all users");
        return userRepository.findAll()
                .stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(toList());
    }

    public User findById(Long id) {
        log.info("finding by id");
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("user not found"));
    }

    public void update(Long userId, UserDto userData) {
        log.info("update user {}", userData);

        userRepository.findById(userId)
                .filter(existingUser -> existingUser(userData, existingUser))
                .map(updatedUser -> userRepository.save())
                .orElseThrow(() -> new RuntimeException("user not found"));
    }

    private boolean existingUser(UserDto userData, User existingUser) {
    }

    @Transactional
    public void delete(Long id) {
        log.info("deleting by id");
        userRepository.deleteById(id);
    }
}
}
