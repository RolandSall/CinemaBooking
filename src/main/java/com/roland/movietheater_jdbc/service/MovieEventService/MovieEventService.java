package com.roland.movietheater_jdbc.service.MovieEventService;

import com.roland.movietheater_jdbc.model.Movie;
import com.roland.movietheater_jdbc.model.MovieEvent;
import com.roland.movietheater_jdbc.repository.MovieEventRepository.IMovieEventRepositoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieEventService implements IMovieEventService {

    @Autowired
    IMovieEventRepositoryDAO movieEventRepository;


    @Override
    public List<Movie> findAllMovieEvents() {
        return  movieEventRepository.findAllMovieEvents();
    }

    @Override
    public MovieEvent createMovieEvent(MovieEvent movieEvent) throws FailedToCreateMovieEventException {
        return movieEventRepository.createMovieEvent(movieEvent);
    }
}
