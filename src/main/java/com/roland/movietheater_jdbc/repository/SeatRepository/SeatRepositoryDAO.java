package com.roland.movietheater_jdbc.repository.SeatRepository;

import com.roland.movietheater_jdbc.model.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SeatRepositoryDAO implements ISeatRepositoryDAO {


    private static final String SQL_STATEMENT_TO_FIND_ALL_SEATS_IN_A_ROOM =
            "SELECT * FROM seat where roomId_seat = ?";

    private static final String SQL_STATEMENT_TO_FIND_ALL_SEATS_AVAILABLE_IN_A_ROOM =
            "SELECT * FROM seat where seat_status = true and roomId_seat = ? ";


    private static final String SQL_STATEMENT_TO_FIND_SEAT_IN_ROOM_BY_ID=
            "SELECT * FROM seat where roomId_seat = ? and seat_id = ?";

    private static final String SQL_STATMENT_TO_CREATE_A_SEAT_IN_A_ROOM =
            "INSERT INTO seat (roomId_seat,seat_row,seat_column,seat_status) values (?,?,?,?)";


    private static final String SQL_STATMENT_TO_DELETE_A_SEAT_IN_A_ROOM =
            "delete from seat where roomId_seat = ? and seat_id = ?";



    private static final String SQL_STATMENT_TO_UPDATE_A_SEAT_IN_A_ROOM =
            "update seat set roomId_seat = ? , seat_row = ? , seat_column = ? , seat_status = ?  where seat_id = ?";

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public List<Seat> getAllSeatsInRoomForAdmin(int cinemaId, int roomId) {
       List<Seat> seatList = jdbcTemplate.query(SQL_STATEMENT_TO_FIND_ALL_SEATS_IN_A_ROOM
               , new SeatMapper()
               , roomId);

       return seatList;
    }


    @Override
    public List<Seat> getAllSeatsInRoomForUser(int cinemaId, int roomId) {
        List<Seat> seatList = jdbcTemplate.query(SQL_STATEMENT_TO_FIND_ALL_SEATS_AVAILABLE_IN_A_ROOM
                , new SeatMapper()
                , roomId);

        return seatList;
    }



    @Override
    public int deleteSeatInRoom(int cinemaId, int roomId, int seatId) {
        jdbcTemplate.update(SQL_STATMENT_TO_DELETE_A_SEAT_IN_A_ROOM
                ,roomId
                ,seatId);
        return seatId;
    }

    @Override
    public Seat getSeatInRoomById(int cinemaId, int roomId, int seatId) {
        Seat seat = jdbcTemplate.queryForObject(SQL_STATEMENT_TO_FIND_SEAT_IN_ROOM_BY_ID
                ,new SeatMapper()
                , roomId
                ,seatId );
        return seat;
    }

    @Override
    public Seat createSeatInRoom(int cinemaId, int roomId, Seat seat) {
        jdbcTemplate.update(SQL_STATMENT_TO_CREATE_A_SEAT_IN_A_ROOM,
                roomId
                ,seat.getSeatRow()
                ,seat.getSeatColumn()
                ,seat.isSeatStatus());

        seat.setRoomId(roomId);
        return seat;

    }

    @Override
    public Seat reserveSeatInRoom(int cinemaId, int roomId, int seatId, Seat seat) {
        jdbcTemplate.update(SQL_STATMENT_TO_UPDATE_A_SEAT_IN_A_ROOM
                ,roomId
                ,seat.getSeatRow()
                ,seat.getSeatColumn()
                ,seat.isSeatStatus()
                ,seatId);

        return seat;
    }

    @Override
    public Seat updateSeatInRoom(int cinemaId, int roomId, int seatId, Seat seat) {
        jdbcTemplate.update(SQL_STATMENT_TO_UPDATE_A_SEAT_IN_A_ROOM
                ,roomId
                ,seat.getSeatRow()
                ,seat.getSeatColumn()
                ,seat.isSeatStatus()
                ,seatId);

        return seat;

    }
}
