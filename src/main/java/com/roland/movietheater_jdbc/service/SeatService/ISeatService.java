package com.roland.movietheater_jdbc.service.SeatService;

import com.roland.movietheater_jdbc.model.Seat;

import java.util.List;

public interface ISeatService {

    public List<Seat> findAllSeats(String movieId);
}
