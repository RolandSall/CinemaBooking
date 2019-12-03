package com.roland.movietheater_jdbc.repository.RatingMovieRepository;

import com.roland.movietheater_jdbc.model.MovieRatingForm;

import java.util.List;

public interface IRatingMovieRepository {

    List<MovieRatingForm> findAllRatingForMovie(int movieId);

    String deleteMovieRatingForMovie(int movieId, int customerId);
}
