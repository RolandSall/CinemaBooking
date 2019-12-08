package com.roland.movietheater_jdbc.service.BookingService;

import com.roland.movietheater_jdbc.model.CineMovieEvent;
import com.roland.movietheater_jdbc.model.CineMovieEventRoomSeat;
import com.roland.movietheater_jdbc.model.CineMovieEventRoomTiming;

import java.util.List;

public interface IBookingService {


    List<CineMovieEvent> getCinemaBranchHostingByMovieId(int movieId);

    List<CineMovieEventRoomTiming> getRoomTimingHostingMovieByMovieIdAndCinemaId(int movieId, int cinemaId);

    List<CineMovieEventRoomSeat> getSeatsAvailableForMovieEvent(int movieId, int cinemaId, int roomId);
}
