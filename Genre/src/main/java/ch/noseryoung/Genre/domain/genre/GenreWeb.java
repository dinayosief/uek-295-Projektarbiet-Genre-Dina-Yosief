package ch.noseryoung.Genre.domain.genre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class GenreWeb {

    @Autowired
    private GenreService service;

    @GetMapping("/genre")
    public ResponseEntity<List<Genre>> getGenre() {
        return ResponseEntity.ok().body(service.getGenre());
    }
}
