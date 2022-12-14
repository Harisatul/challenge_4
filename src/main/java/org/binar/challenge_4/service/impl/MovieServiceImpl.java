package org.binar.challenge_4.service.impl;

import org.binar.challenge_4.entities.Movie;
import org.binar.challenge_4.entities.Schedule;
import org.binar.challenge_4.payload.ApiResponse;
import org.binar.challenge_4.repository.MovieRepository;
import org.binar.challenge_4.repository.ScheduleRepository;
import org.binar.challenge_4.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;

    }
    @Override
    public ApiResponse getAllMovie() {
        List<Movie> all = movieRepository.findAll();
        return new ApiResponse(Boolean.TRUE, "success", all);
    }

    @Override
    public ApiResponse addMovie(Movie movie) {
        Movie save = movieRepository.save(movie);
        return new ApiResponse(Boolean.TRUE, "successfully added" + movie.getMovieTittle(), save);
    }

    @Override
    public ApiResponse updateMovie(Long id) {
        Movie movie = movieRepository.findById(id).orElseThrow();
        return new ApiResponse(Boolean.TRUE, "successfully update", movie);
    }

    @Override
    public ApiResponse deleteMovie(Long id) {
        Movie movie = movieRepository.findById(id).orElseThrow();
        movieRepository.delete(movie);
        return new ApiResponse(Boolean.TRUE, "successfully deleted movie with id " + id);
    }


}
