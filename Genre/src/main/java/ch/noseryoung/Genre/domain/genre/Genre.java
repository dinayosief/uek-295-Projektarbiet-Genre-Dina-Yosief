package ch.noseryoung.Genre.domain.genre;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
@Table(name = "genre")
public class Genre {

    @Id
    @NotBlank
    private String name;
    @NotBlank
    private String popularity;
    @NotBlank
    private String description;

    public Object getDescription(String description) {
        return null;
    }
}
