package com.roland.movietheater_jdbc.repository.BookingRepository;

import com.roland.movietheater_jdbc.model.CineMovieEvent;
import com.roland.movietheater_jdbc.model.CineMovieEventRoomSeat;
import com.roland.movietheater_jdbc.model.CineMovieEventRoomTiming;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IBookingRepository {


    List<CineMovieEvent> getCinemaBranchHostingByMovie(int movieId);

    List<CineMovieEventRoomTiming> getRoomTimingHostingMovieByMovieIdAndCinemaId(int movieId, int cinemaId);

    List<CineMovieEventRoomSeat> getSeatsAvailableForMovieEvent(int movieId, int cinemaId, int roomId);
}
