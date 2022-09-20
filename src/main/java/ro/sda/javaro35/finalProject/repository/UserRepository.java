//package ro.sda.javaro35.finalProject.repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//import ro.sda.javaro35.finalProject.entities.user.User;
//import java.util.Optional;
//@Repository
//@Transactional(readOnly = true)
//public interface UserRepository extends JpaRepository<User, Long> {
//    Optional<Object> findByEmail(String email);
//
//    @Transactional
//    @Modifying
//    @Query("UPDATE User a " +
//            "SET a.enabled = TRUE WHERE a.email = ?1")
//    int enableAppUser(String email);
//
//    @Query("Select a from User a where a.email = :email")
//    User authenticate(@Param("email") String email);
//}
