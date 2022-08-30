package ro.sda.javaro35.finalProject.entities.user;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ro.sda.javaro35.finalProject.entities.flight.Ticket;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    Long id;

    String firstName;
    String lastName;

    @Column(nullable=false, unique=true)
    @Email
    String email;
    @Column(nullable=false)
    String password;

    @Enumerated(EnumType.STRING)
    RoleType roleType;

    Boolean locked = false;
    Boolean enabled = false;

    // one user buys many tickets
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set <Ticket> tickets;

    public User(String firstName, String lastName, String email, String password, RoleType roleType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roleType = roleType;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority =
                new SimpleGrantedAuthority(roleType.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {return password;}
    @Override
    public String getUsername() {return email;}

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && roleType == user.roleType && Objects.equals(locked, user.locked) && Objects.equals(enabled, user.enabled) && Objects.equals(tickets, user.tickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, password, roleType, locked, enabled, tickets);
    }
}
