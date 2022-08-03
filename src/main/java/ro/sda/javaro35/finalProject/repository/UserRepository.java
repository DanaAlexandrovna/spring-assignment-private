package ro.sda.javaro35.finalProject.repository;

import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.javaro35.finalProject.dto.user.UserDto;
import ro.sda.javaro35.finalProject.entities.user.User;

import javax.persistence.metamodel.SingularAttribute;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmailIgnoreCase(String email);



}
