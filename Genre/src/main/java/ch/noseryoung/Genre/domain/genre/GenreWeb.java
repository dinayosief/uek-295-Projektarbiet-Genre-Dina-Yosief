package ch.noseryoung.Genre.domain.genre;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/genre")
public class GenreWeb {

    @Autowired
    private GenreService service;

    @Autowired
    public GenreWeb(GenreService service) {
        this.service = service;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('READ')")
    @Operation(summary = "Gets all Genre", description = "This endpoint will get all of the Genre`s in the database.")
    public ResponseEntity<List<Genre>> getAllGenres() {
        return ResponseEntity.ok().body(service.getAllGenres());
    }

    @GetMapping("/{name}")
    @PreAuthorize("hasAuthority('READ')")
    @Operation(summary = "Gets gente from given Name", description = "This endpoint will only return a Genre by the given name")
    public ResponseEntity<Genre> getGenreByName(@PathVariable("name") String name) throws Exception {
        return ResponseEntity.ok().body(service.getGenreByName(name));
    }

    @DeleteMapping("/{name}")
    @PreAuthorize("hasAuthority('DELETE')")
    @Operation(summary = "Deletes Genre from given name", description = "This endpoint deletes the genre with the given name")
    public void deleteGenre(@PathVariable String name) {
        service.deleteGenre(name);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException noSuchElementException) {
        return ResponseEntity.status(404).body("This Genre does not exist!");
    }

    @PostMapping
    @PreAuthorize("hasAuthority('CREATE')")
    @Operation(summary = "Creates genre with data", description = "This endpoint creates a new supplier with the given information")
    public Genre createGenre(@RequestBody @Valid Genre genre) {
        return service.createGenre(genre);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('UPDATE')")
    @Operation(summary = "Updates changes to genre", description = "This endpoint only makes changes to the genre by the given name")
    public Genre updateGenre(@PathVariable int id, @RequestBody Genre genre) {
        genre.setName(genre.getName());
        return service.updateGenre(genre.getName(), genre);

    }

}
