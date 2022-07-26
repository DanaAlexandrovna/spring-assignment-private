package ro.sda.javaro35.finalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.javaro35.finalProject.entities.user.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    void create(User user);
    void delete(User user);
    void update(User user);

    Optional<User> findByNameIgnoreCase(String name);

    User findByEmailIgnoreCase(String email);

}
