package com.roland.movietheater_jdbc.service.SeatService;

import com.roland.movietheater_jdbc.model.Seat;
import com.roland.movietheater_jdbc.service.RoomService.FailedToFindRoomInCinemaBranchException;

import java.util.List;

public interface ISeatService {



    List<Seat> getAllSeatsInRoomForAdmin(int cinemaId, int roomId) throws FailedToFindRoomInCinemaBranchException;

    int deleteSeatInRoom(int cinemaId, int roomId, int seatId) throws FailedToDeleteSeatInCinemaBranchRoom;

    Seat getSeatInRoomById(int cinemaId, int roomId, int seatId) throws FailedToFindSeatInCinemaBranchRoom;

    List<Seat> createSeatInRoom(int cinemaId, int roomId, int roomCapacity, Seat seat) throws FailedToCreateSeatInCinemaBranchRoom;

    Seat reserveSeatInRoom(int cinemaId, int roomId, int seatId, Seat seat) throws FailedToReserveSeatInCinemaBranch;



    Seat updateSeatInRoom(int cinemaId, int roomId, int seatId, Seat seat) throws FailedToUpdateSeatInCinemaBranchRoom;

    List<Seat> getAllSeatsInRoomForUser(int cinemaId, int roomId);

    String deleteAllSeatsInRoom(int cinemaId, int roomId) throws FailedToDeleteSeatInCinemaBranchRoom;
}
