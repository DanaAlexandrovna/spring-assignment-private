package ro.sda.javaro35.finalProject.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.javaro35.finalProject.dto.user.UserDto;
import ro.sda.javaro35.finalProject.entities.user.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

   Optional<User> loadUserByUsername(String email);
   Optional<User> findByEmailIgnoreCase(String email);

   Optional<User> findById(Long id);

//   Object save (User user);

   List <User> findAll();

   void update();

   void delete(Long id);





}
