package br.com.fiap.movies.controllers;

import br.com.fiap.movies.models.Movie;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
public class MovieController {

    @GetMapping("/")
    public String healthCheck() {
        return """
                { 
                    "status": "ok",
                    "message": "API is running"
                }
                """;
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
