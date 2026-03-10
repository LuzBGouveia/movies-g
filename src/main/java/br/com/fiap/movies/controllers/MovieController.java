package br.com.fiap.movies.controllers;

import br.com.fiap.movies.models.Movie;
import br.com.fiap.movies.services.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@RequestMapping("/movies")
@Slf4j
public class MovieController {

    private static final Logger log = LoggerFactory.getLogger(MovieController.class);
    @Autowired
    private MovieService service; // Injeção de dependência - IoC

    @GetMapping
    public List<Movie> listAll(){
        return service.getAllMovies();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie){ //binding
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addMovie(movie));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id){
        log.info("Obtendo dados do filme {}", id);

        return ResponseEntity.ok(service.getMovieById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        log.info("Deletando filme com id {}", id);
        service.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
        log.info("Atualizando filme do id  {} com os dados {}", id, movie);
        return ResponseEntity.ok(service.updateMovie(id, movie));
    }
}
