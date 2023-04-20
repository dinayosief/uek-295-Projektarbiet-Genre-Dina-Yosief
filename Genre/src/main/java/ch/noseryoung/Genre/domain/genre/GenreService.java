package ch.noseryoung.Genre.domain.genre;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import java.util.List;
@Log4j2
@Service
public class GenreService {

    private GenreRepository repository;

    public void setGenreRepository(GenreRepository repository) {
        this.repository = repository;
    }

    public List<Genre> getAllGenres(){
        return repository.findAll();
    }

    public Genre getGenreByName(String name) {
        return repository.findById(name).orElseThrow();
    }

    public void deleteGenre(String name) {
        repository.delete(getGenreByName(name));
    }

    public Genre updateGenre(String name, Genre genre) {
        Genre existingGenre = repository.findById(name).orElseThrow();
        existingGenre.setPopularity(genre.getPopularity());
        existingGenre.setDescription(genre.getDescription());
        return repository.save(existingGenre);
    }

    public Genre createGenre(Genre genre) {
        return repository.save(genre);
    }
}
