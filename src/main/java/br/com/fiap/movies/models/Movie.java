package br.com.fiap.movies.models;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Movie {
    private Long id;
    private String title;
    private int rating;
    private String synopsis;
    private LocalDate releaseDate;
    private String duration;
    private String genre;

}
