package com.roland.movietheater_jdbc.service.SeatService;

import com.roland.movietheater_jdbc.model.Seat;
import com.roland.movietheater_jdbc.repository.SeatRepository.ISeatRepositoryDAO;
import com.roland.movietheater_jdbc.repository.SeatRepository.SeatRepositoryDAO;
import com.roland.movietheater_jdbc.service.RoomService.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public int deleteSeatInRoom(int cinemaId, int roomId, int seatId) {
        return seatRepositoryDAO.deleteSeatInRoom(cinemaId,roomId,seatId);
    }

    @Override
    public Seat getSeatInRoomById(int cinemaId, int roomId, int seatId) {
        return seatRepositoryDAO.getSeatInRoomById(cinemaId,roomId,seatId);
    }

    @Override
    public Seat createSeatInRoom(int cinemaId, int roomId, Seat seat) {
        return seatRepositoryDAO.createSeatInRoom(cinemaId,roomId,seat);
    }

    @Override
    public Seat reserveSeatInRoom(int cinemaId, int roomId,int seatId, Seat seat) {
        return seatRepositoryDAO.reserveSeatInRoom(cinemaId,roomId, seatId,seat);
    }

    @Override
    public Seat updateSeatInRoom(int cinemaId, int roomId, int seatId, Seat seat) {
        return seatRepositoryDAO.updateSeatInRoom(cinemaId,roomId, seatId ,seat);
    }


}
