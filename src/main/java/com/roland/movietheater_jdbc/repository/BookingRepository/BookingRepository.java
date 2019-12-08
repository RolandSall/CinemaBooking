package com.roland.movietheater_jdbc.repository.BookingRepository;

import com.roland.movietheater_jdbc.model.CineMovieEvent;
import com.roland.movietheater_jdbc.model.CineMovieEventRoomSeat;
import com.roland.movietheater_jdbc.model.CineMovieEventRoomTiming;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookingRepository implements   IBookingRepository {

    private static final String SQL_STATEMENT_TO_FIND_CINEMA_BRANCH_HOSTING_MOVIE_BY_ID =
            "select C.cinema_id, ME.movie_id, C.cinema_name,  C.cinema_address, C.cinema_phone  from movie_event ME, room R, cinemabranch C " +
                    "where ME.room_id = R.room_id " +
                    " And C.cinema_id = R.cinema_branch And movie_id = ? Group by cinema_address;";

    private static final String  SQL_STATEMENT_TO_FIND_ROOM_TIMING_HOSTING_MOVIE_BY_ID_IN_CINEMA_BRANCH =
            "select C.cinema_id, ME.* from movie_event ME, room R, cinemabranch C  where ME.room_id = R.room_id And C.cinema_id = R.cinema_branch And movie_id = ? And cinema_id = ? ";

    private static final String SQL_STATEMENT_TO_FIND_SEATS_AVAILABLE_FOR_MOVIE_EVENT =
            "select C.cinema_id, ME.movie_eventId , S.* from movie_event ME, room R, cinemabranch C , seat S" +
                    " where ME.room_id = R.room_id " +
                    " And C.cinema_id = R.cinema_branch" +
                    " And S.roomId_seat = R.room_id " +
                    " And movie_id = ? And cinema_id = ? And R.room_id = ?  group by seat_id";

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public List<CineMovieEvent> getCinemaBranchHostingByMovie(int movieId) {
        return jdbcTemplate.query(SQL_STATEMENT_TO_FIND_CINEMA_BRANCH_HOSTING_MOVIE_BY_ID, new CineMovieEventMapper(),movieId);
    }

    @Override
    public List<CineMovieEventRoomTiming> getRoomTimingHostingMovieByMovieIdAndCinemaId(int movieId, int cinemaId) {
        return jdbcTemplate.query(SQL_STATEMENT_TO_FIND_ROOM_TIMING_HOSTING_MOVIE_BY_ID_IN_CINEMA_BRANCH, new CineMovieEventRoomTimingMapper(), movieId,cinemaId);
    }

    @Override
    public List<CineMovieEventRoomSeat> getSeatsAvailableForMovieEvent(int movieId, int cinemaId, int roomId) {
        return  jdbcTemplate.query(SQL_STATEMENT_TO_FIND_SEATS_AVAILABLE_FOR_MOVIE_EVENT, new CineMovieEventRoomSeatMapper(),movieId,cinemaId,roomId);
    }
}
