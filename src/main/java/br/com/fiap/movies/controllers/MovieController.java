package br.com.fiap.movies.controllers;

import br.com.fiap.movies.models.Movie;
import br.com.fiap.movies.services.MovieService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("movies")
@Slf4j
public class MovieController {

    @Autowired
    private MovieService service; // Injeção de dependência - IoC

    @GetMapping
    public List<Movie> listAll(){
        return service.getAllMovies();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Movie createMovie(@RequestBody Movie movie){ //binding
        return service.addMovie(movie);
    }

    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable Long id){
        log.info("Obtendo dados do filme {}", id);
        var optionalMovie = service.getMovieById(id);

        if(optionalMovie.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return optionalMovie.get();
    }

}
