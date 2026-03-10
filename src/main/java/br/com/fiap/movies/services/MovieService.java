package br.com.fiap.movies.services;

import br.com.fiap.movies.models.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class MovieService {

    private List<Movie> repository = new ArrayList<>();

    public List<Movie> getAllMovies(){
        return repository;
    }

    public Movie addMovie(Movie movie){
        movie.setId(Math.abs( new Random().nextLong() ));
        repository.add(movie);
        return movie;
    }

    public Optional<Movie> getMovieById(Long id){
        return repository.stream()
                .filter(movie -> movie.getId().equals(id)) // lambda expression - arrow function
                .findFirst();
    }

}
