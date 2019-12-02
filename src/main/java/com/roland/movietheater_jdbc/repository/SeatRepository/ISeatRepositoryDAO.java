package com.roland.movietheater_jdbc.repository.SeatRepository;

import com.roland.movietheater_jdbc.model.Seat;

import java.util.List;

public interface ISeatRepositoryDAO {

    public List<Seat> findAllSeats(String roomId);
}
