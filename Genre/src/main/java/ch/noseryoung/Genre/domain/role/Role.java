package ch.noseryoung.Genre.domain.role;

import ch.noseryoung.Genre.domain.authority.Authority;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int role_id;

    @Size(min = 2, max = 10)
    private String role_name;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "role_authority",
            joinColumns = @JoinColumn(name = "id_role", referencedColumnName = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "id_authority", referencedColumnName = "authority_id"))
    Set<Authority> savedAuthorities;
}
