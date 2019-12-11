package com.roland.movietheater_jdbc.service.SeatService;

import com.roland.movietheater_jdbc.model.Seat;
import com.roland.movietheater_jdbc.service.RoomService.FailedToFindRoomInCinemaBranchException;

import java.util.List;

public interface ISeatService {



    List<Seat> getAllSeatsInRoomForAdmin(int cinemaId, int roomId) throws FailedToFindRoomInCinemaBranchException;

    Seat getSeatInRoomById(int cinemaId, int roomId, int seatId) throws FailedToFindSeatInCinemaBranchRoom;

    List<Seat> createSeatsInRoom(int cinemaId, int roomId, int roomCapacity) throws FailedToCreateSeatInCinemaBranchRoom;


    List<Seat> getAllSeatsInRoomForUser(int cinemaId, int roomId);

    String deleteAllSeatsInRoom(int cinemaId, int roomId) throws FailedToDeleteSeatInCinemaBranchRoom;
}
