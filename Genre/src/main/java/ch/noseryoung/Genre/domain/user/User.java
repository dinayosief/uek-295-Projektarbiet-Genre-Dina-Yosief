package ch.noseryoung.Genre.domain.user;

import ch.noseryoung.Genre.domain.role.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;

    @Size(min = 5, max = 30)
    private String username;

    @Size(min = 3, max = 30)
    private String password;
    @ManyToOne
    @JoinColumn(name = "user_role", referencedColumnName = "role_id")
    Role role;

    public User(User user) {
        this.user_id = user.getUser_id();
        this.username = user.getUsername();
    }


    public User() {

    }
}
