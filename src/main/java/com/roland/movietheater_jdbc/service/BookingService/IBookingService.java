package com.roland.movietheater_jdbc.service.BookingService;

import com.roland.movietheater_jdbc.model.CineMovieEvent;
import com.roland.movietheater_jdbc.model.CineMovieEventRoomSeat;
import com.roland.movietheater_jdbc.model.CineMovieEventRoomTiming;
import com.roland.movietheater_jdbc.service.Customer.FailedToFindAccountException;

import java.util.List;

public interface IBookingService {


    List<CineMovieEvent> getCinemaBranchHostingByMovieId(int movieId);

    List<CineMovieEventRoomTiming> getRoomTimingHostingMovieByMovieIdAndCinemaId(int movieId, int cinemaId);

    List<CineMovieEventRoomSeat> getSeatAllSeatsForMovieEvent(int movieId, int cinemaId, int roomId);

    String reserveSeatForUser(int movieId , int cinemaId, int roomId, int seatId, int userId, double ticketPrice) throws FailedToFindAccountException;
}
