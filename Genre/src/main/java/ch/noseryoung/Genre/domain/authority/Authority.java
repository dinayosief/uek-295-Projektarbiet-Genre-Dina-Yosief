package ch.noseryoung.Genre.domain.authority;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "authority")
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authority_id;

    @Size(min = 2, max = 10)
    private String name;
}
