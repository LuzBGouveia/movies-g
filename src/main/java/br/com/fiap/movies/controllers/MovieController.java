package br.com.fiap.movies.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

}
