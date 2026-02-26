package br.com.fiap.movies.controllers;

import br.com.fiap.movies.models.Movie;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
public class MovieController {

    //record é como se fosse uma classe imutavel. Também dá pra ser criado em um arquivo separado.
    record HealthStatus(String status, String message){};

    //Jackson converte o objeto Movie pra JSON automaticamente.
    @GetMapping("/")
    public HealthStatus healthCheck() {
        return new HealthStatus("ok", "API is running");
    }

    @GetMapping("/movies")
    public Movie listAll(){
        return new Movie(
                "Titanic",
                5,
                "Todo mundo morreu, acabou :D",
                LocalDate.of(1997,12,1),
                "2h30",
                "Romance"
        );
    }
}