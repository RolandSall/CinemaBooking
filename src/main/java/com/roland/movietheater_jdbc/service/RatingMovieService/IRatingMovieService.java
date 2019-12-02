package com.roland.movietheater_jdbc.service.RatingMovieService;

import com.roland.movietheater_jdbc.model.MovieRatingForm;

import java.util.List;

public interface IRatingMovieService {

    List<MovieRatingForm> findAllRatingForMovie(int movieId);

    String deleteMovieRatingForMovie(int movieId, int customerId);
}
