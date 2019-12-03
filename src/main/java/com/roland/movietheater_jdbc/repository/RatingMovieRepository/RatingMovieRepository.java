package com.roland.movietheater_jdbc.repository.RatingMovieRepository;

import com.roland.movietheater_jdbc.model.MovieRatingForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RatingMovieRepository implements  IRatingMovieRepository {

    private static final String SQL_STATEMENT_TO_FIND_RATING_FOR_MOVIE ="select movie_rating.* , customer.customer_username from movie_rating , customer where movie_rating.customer_ratedId = customer.customer_id And movie_ratedId = ? ";

    private static final String SQL_STATEMENT_TO_DELETE_RATING_FOR_MOVIE ="select * from movie_rating where customer_rateId = ? and movie_ratedId = ?";


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<MovieRatingForm> findAllRatingForMovie(int movieId) {

        List<MovieRatingForm> movieRatingFormList = jdbcTemplate.query(SQL_STATEMENT_TO_FIND_RATING_FOR_MOVIE,new MovieRatingFormMapper(),movieId);

        return movieRatingFormList;
    }

    @Override
    public String deleteMovieRatingForMovie(int movieId, int customerId) {
         jdbcTemplate.update(SQL_STATEMENT_TO_DELETE_RATING_FOR_MOVIE, customerId, movieId);
         return "Rating of Customer id: " + customerId + " for movie id : " + movieId;
    }
}
