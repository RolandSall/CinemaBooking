package com.roland.movietheater_jdbc.controller.movieEvent;

import com.roland.movietheater_jdbc.controller.movie.MovieApiResponseForAdmin;
import com.roland.movietheater_jdbc.model.Movie;
import com.roland.movietheater_jdbc.model.MovieEvent;
import com.roland.movietheater_jdbc.service.MovieEventService.FailedToCreateMovieEventException;
import com.roland.movietheater_jdbc.service.MovieEventService.MovieEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieEventController {

    private MovieEventService movieEventService;


    @Autowired
    public MovieEventController(MovieEventService movieEventService) {
        this.movieEventService = movieEventService;


    }

    @GetMapping("/movieEvent")
    public ResponseEntity getAllMovieEventsForAdmin() {
        List<Movie> movieList = movieEventService.findAllMovieEvents();
        List<MovieApiResponseForAdmin> responseList = buildMovieResponse(movieList);
        return ResponseEntity.status(HttpStatus.OK).body(responseList);
    }

    @PostMapping("/admin/cinemas/{cinemaId}/rooms/{roomId}/movies/{movieId}")
    public ResponseEntity createMovieEvent(@PathVariable("cinemaId") int cinemaId, @PathVariable("roomId") int roomId, @PathVariable("movieId") int movieId,
                                           @RequestBody MovieEventApiRequestForAdminAndUser request) {
        try {

            MovieEvent movieEvent = movieEventService.createMovieEvent(getMovieEvent(request, cinemaId, roomId, movieId));

            MovieEventApiResponseForUserAndAdmin response = buildEventMovieResponse(movieEvent);
            return ResponseEntity.status(HttpStatus.OK).body(response);

        } catch (FailedToCreateMovieEventException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }




    }

    private MovieEvent getMovieEvent(MovieEventApiRequestForAdminAndUser request, int cinemaId, int roomId, int movieId) {
        return new MovieEvent().builder()
                .movieId(movieId)
                .roomId(roomId)
                .movieStartTime(request.getMovieStartTime())
                .movieEndTime(request.getMovieEndTime())
                .build();
    }

    private MovieEventApiResponseForUserAndAdmin buildEventMovieResponse(MovieEvent movieEvent) {
        return new MovieEventApiResponseForUserAndAdmin().builder()
                .movieId(movieEvent.getMovieId())
                .roomId(movieEvent.getRoomId())
                .movieStartTime(movieEvent.getMovieStartTime())
                .movieEndTime(movieEvent.getMovieEndTime())
                .build();
    }


    private List<MovieApiResponseForAdmin> buildMovieResponse(List<Movie> movieList) {
        List<MovieApiResponseForAdmin> responseList = new ArrayList<>();
        for (Movie movie : movieList) {
            responseList.add(getMovieApiResponse(movie));
        }

        return responseList;
    }

    private MovieApiResponseForAdmin getMovieApiResponse(Movie movie) {
        return new MovieApiResponseForAdmin().builder()
                .movieId(movie.getMovieId())
                .movieName(movie.getMovieName())
                .movieDescription(movie.getMovieDescription())
                .movieDuration(movie.getMovieDuration())
                .movieGenre(movie.getMovieGenre())
                .movieDirectors(movie.getMovieDirectors())
                .movieStars(movie.getMovieStars())
                .movieUrlImage(movie.getMovieUrlImage())
                .movieUrlPosterImage(movie.getMovieUrlPosterImage())
                .movieReleaseDate(movie.getMovieReleaseDate())
                .build();

    }
}
