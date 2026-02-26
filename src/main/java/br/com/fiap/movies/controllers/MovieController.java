package br.com.fiap.movies.controllers;

import br.com.fiap.movies.models.Movie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
// permite diferentes tipos de log
@Slf4j
public class MovieController {

    //record é como se fosse uma classe imutavel. Também dá pra ser criado em um arquivo separado.
    record HealthStatus(String status, String message){};

    //Jackson converte o objeto Movie pra JSON automaticamente.
    @GetMapping("/")
    public HealthStatus healthCheck() {
        return new HealthStatus("ok", "API is running");
    }

    @GetMapping("/movies")
    public List<Movie> listAll(){
        return List.of( new Movie (
                "Titanic",
                5,
                "Todo mundo morreu, acabou :D",
                LocalDate.of(1997,12,1),
                "2h30",
                "Romance"
        )
        );
    }

    @PostMapping("/movies")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Movie createMovie(@RequestBody Movie movie) {
        // log.info = sout, porém com mais informações.
        log.info("Cadastrando filme: " + movie);
        return movie;
    }
}