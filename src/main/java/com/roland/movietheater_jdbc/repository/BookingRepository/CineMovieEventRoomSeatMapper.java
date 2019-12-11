package com.roland.movietheater_jdbc.repository.BookingRepository;

import com.roland.movietheater_jdbc.model.CineMovieEventRoomSeat;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class CineMovieEventRoomSeatMapper implements RowMapper<CineMovieEventRoomSeat> {



    @Override
    public CineMovieEventRoomSeat mapRow(ResultSet resultSet, int i) throws SQLException {
        CineMovieEventRoomSeat cineMovieEventRoomSeat = new CineMovieEventRoomSeat();
        cineMovieEventRoomSeat.setCinemaId(resultSet.getInt("cinema_id"));
        cineMovieEventRoomSeat.setMovieEventId(resultSet.getInt("movie_eventId"));
        cineMovieEventRoomSeat.setSeatId(resultSet.getInt("seat_id"));
        cineMovieEventRoomSeat.setRoomIdOfSeat(resultSet.getInt("roomId_seat"));
        cineMovieEventRoomSeat.setSeatRow(resultSet.getInt("seat_row"));
        cineMovieEventRoomSeat.setSeatColumn(resultSet.getInt("seat_column"));

        return cineMovieEventRoomSeat;
    }
}
