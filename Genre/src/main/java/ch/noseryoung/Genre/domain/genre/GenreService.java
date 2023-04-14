package ch.noseryoung.Genre.domain.genre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    @Autowired
    private GenreRepository repository;


    public List<Genre> getGenre() {
        return repository.findAll();
    }
}
