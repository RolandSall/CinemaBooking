package com.roland.movietheater_jdbc.service.SeatService;

import com.roland.movietheater_jdbc.model.Seat;

import java.util.List;

public interface ISeatService {



    List<Seat> getAllSeatsInRoomForAdmin(int cinemaId, int roomId);

    int deleteSeatInRoom(int cinemaId, int roomId, int seatId);

    Seat getSeatInRoomById(int cinemaId, int roomId, int seatId);

    Seat createSeatInRoom(int cinemaId, int roomId, Seat seat);

    Seat reserveSeatInRoom(int cinemaId, int roomId, int seatId, Seat seat);



    Seat updateSeatInRoom(int cinemaId, int roomId, int seatId, Seat seat);

    List<Seat> getAllSeatsInRoomForUser(int cinemaId, int roomId);
}
