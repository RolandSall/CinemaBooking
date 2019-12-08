package com.roland.movietheater_jdbc.service.BookingService;

import com.roland.movietheater_jdbc.model.CineMovieEvent;
import com.roland.movietheater_jdbc.model.CineMovieEventRoomSeat;
import com.roland.movietheater_jdbc.model.CineMovieEventRoomTiming;
import com.roland.movietheater_jdbc.repository.BookingRepository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService implements  IBookingService {

    private BookingRepository bookingRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public List<CineMovieEvent> getCinemaBranchHostingByMovieId(int movieId) {
        return bookingRepository.getCinemaBranchHostingByMovie(movieId);
    }

    @Override
    public List<CineMovieEventRoomTiming> getRoomTimingHostingMovieByMovieIdAndCinemaId(int movieId, int cinemaId) {
        return bookingRepository.getRoomTimingHostingMovieByMovieIdAndCinemaId(movieId,cinemaId);
    }

    @Override
    public List<CineMovieEventRoomSeat> getSeatsAvailableForMovieEvent(int movieId, int cinemaId, int roomId) {
        return  bookingRepository.getSeatsAvailableForMovieEvent(movieId,cinemaId,roomId);
    }
}
