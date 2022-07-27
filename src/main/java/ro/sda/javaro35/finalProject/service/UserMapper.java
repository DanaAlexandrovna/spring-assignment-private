package ro.sda.javaro35.finalProject.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ro.sda.javaro35.finalProject.dto.user.UserDto;
import ro.sda.javaro35.finalProject.entities.user.User;
import ro.sda.javaro35.finalProject.repository.UserRepository;


@Component
@Service
@Setter
@Getter
@AllArgsConstructor
public class UserMapper  {

    final UserRepository userRepository;


    public UserDto convertToDto(User entity) {
        UserDto userForm = new UserDto();
        userForm.setId(entity.getId());
        userForm.setName(entity.getName());
        userForm.setLastName(entity.getLastName());
        userForm.setDateOfBirth(entity.getDateOfBirth());
        userForm.setEmail(entity.getEmail());
        userForm.setPassword(entity.getPassword());
        userForm.setRoles(entity.getRoles());
        return userForm;
    }

    public User convertToEntity(UserDto dto) {
        User user = null;
        if (dto.getId() != null) { // din baza de date aducem o entitate sa lucram cu ea
            user = userRepository.findById(dto.getId()).orElse(new User());
        } else { // altfel se va creea alta
            user = new User();
        }

        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setLastName(dto.getLastName());
        user.setDateOfBirth(dto.getDateOfBirth());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setRoles(dto.getRoles());
        return user;
    }

}
