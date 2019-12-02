package com.roland.movietheater_jdbc.repository.MovieEventRepository;

import com.roland.movietheater_jdbc.model.Movie;
import com.roland.movietheater_jdbc.model.MovieEvent;
import com.roland.movietheater_jdbc.service.MovieEventService.FailedToCreateMovieEventException;

import java.util.List;

public interface IMovieEventRepositoryDAO {


    List<Movie> findAllMovieEvents();

    MovieEvent createMovieEvent(MovieEvent movieEvent) throws FailedToCreateMovieEventException;
}
