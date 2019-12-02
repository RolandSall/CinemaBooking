package com.roland.movietheater_jdbc.service.SeatService;

import com.roland.movietheater_jdbc.model.Seat;
import com.roland.movietheater_jdbc.repository.SeatRepository.ISeatRepositoryDAO;
import com.roland.movietheater_jdbc.service.RoomService.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService implements  ISeatService {

    @Autowired
    ISeatRepositoryDAO iSeatRepositoryDAO;

    @Override
    public List<Seat> findAllSeats(String movieId) {
        return null;
    }
}
