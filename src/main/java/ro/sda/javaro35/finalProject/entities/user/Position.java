package ro.sda.javaro35.finalProject.entities.user;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @OneToMany
    private List<User> userList;
    private PositionType positionType;
}
