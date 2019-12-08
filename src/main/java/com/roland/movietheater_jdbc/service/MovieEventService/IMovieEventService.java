package com.roland.movietheater_jdbc.service.MovieEventService;

import com.roland.movietheater_jdbc.model.Movie;
import com.roland.movietheater_jdbc.model.MovieEvent;

import java.util.List;

public interface IMovieEventService {


    List<Movie> findAllMovieEvents();

    MovieEvent createMovieEvent(MovieEvent movieEvent) throws FailedToCreateMovieEventException;

    String  deleteMovieEvent(int id, int cinemaId, int roomId, int movieId) throws  FailedToDeleteMovieEventException;

    List<MovieEvent> getMovieEventTiming(int movieId);
}
