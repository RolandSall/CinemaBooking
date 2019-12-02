package com.roland.movietheater_jdbc.service.RatingMovieService;

import com.roland.movietheater_jdbc.model.MovieRatingForm;
import com.roland.movietheater_jdbc.repository.RatingMovieRepository.RatingMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingMovieService implements  IRatingMovieService{

    private RatingMovieRepository ratingMovieRepository;

    @Autowired
    public RatingMovieService(RatingMovieRepository ratingMovieRepository){
        this.ratingMovieRepository = ratingMovieRepository;
    }

    @Override
    public List<MovieRatingForm> findAllRatingForMovie(int movieId) {
        return ratingMovieRepository.findAllRatingForMovie(movieId);
    }

    @Override
    public String deleteMovieRatingForMovie(int movieId, int customerId) {
        return ratingMovieRepository.deleteMovieRatingForMovie(movieId,customerId);
    }
}
