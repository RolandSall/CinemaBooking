package com.roland.movietheater_jdbc.service.SeatService;

import com.roland.movietheater_jdbc.model.Seat;
import com.roland.movietheater_jdbc.repository.SeatRepository.ISeatRepositoryDAO;
import com.roland.movietheater_jdbc.repository.SeatRepository.SeatRepositoryDAO;
import com.roland.movietheater_jdbc.service.RoomService.FailedToFindRoomInCinemaBranchException;
import com.roland.movietheater_jdbc.service.RoomService.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeatService implements  ISeatService {

    SeatRepositoryDAO seatRepositoryDAO;

    @Autowired
    public SeatService(SeatRepositoryDAO seatRepositoryDAO) {
        this.seatRepositoryDAO = seatRepositoryDAO;
    }

    @Override
    public List<Seat> getAllSeatsInRoomForAdmin(int cinemaId, int roomId) {

        return seatRepositoryDAO.getAllSeatsInRoomForAdmin(cinemaId,roomId);
    }

    @Override
    public List<Seat> getAllSeatsInRoomForUser(int cinemaId, int roomId) {
        return seatRepositoryDAO.getAllSeatsInRoomForUser(cinemaId,roomId);
    }

    @Override
    public Seat getSeatInRoomById(int cinemaId, int roomId, int seatId) throws FailedToFindSeatInCinemaBranchRoom {
        return seatRepositoryDAO.getSeatInRoomById(cinemaId,roomId,seatId);
    }


    @Override
    public List<Seat> createSeatsInRoom(int cinemaId, int roomId, int roomCapacity) throws FailedToCreateSeatInCinemaBranchRoom {
        return  createSeatsInRoomLoop(cinemaId,roomId,roomCapacity);

    }


    @Override
    public String deleteAllSeatsInRoom(int cinemaId, int roomId) throws FailedToDeleteSeatInCinemaBranchRoom {
        return seatRepositoryDAO.deleteAllSeatsInRoom(cinemaId,roomId);
    }


       private List<Seat> createSeatsInRoomLoop(int cinemaId, int roomId, int roomCapacity) throws FailedToCreateSeatInCinemaBranchRoom {

       if (roomCapacity == 50 || roomCapacity == 100)
           return createSeat(cinemaId,roomId,roomCapacity, 10);
         else
          return createSeat(cinemaId,roomId,roomCapacity, 20);



    }

    private List<Seat> createSeat(int cinemaId, int roomId, int roomCapacity, int nb) throws FailedToCreateSeatInCinemaBranchRoom {
        List<Seat> seatList = new ArrayList<>();
        Seat seat = new Seat();

        for (int counter = 0; counter < roomCapacity; counter++) {
            int seatRow = counter / nb;
            int seatColumn = counter % nb;
            seat.setSeatRow(seatRow);
            seat.setSeatColumn(seatColumn);
           Seat seatCreated = seatRepositoryDAO.createSeatInRoom(cinemaId, roomId,seat);
           seatList.add(seatCreated);

        }

        return seatList;
    }



}
