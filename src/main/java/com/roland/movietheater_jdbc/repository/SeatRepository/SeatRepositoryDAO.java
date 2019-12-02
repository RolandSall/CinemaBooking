package com.roland.movietheater_jdbc.repository.SeatRepository;

import com.roland.movietheater_jdbc.model.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SeatRepositoryDAO implements ISeatRepositoryDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Seat> findAllSeats(String roomId) {
        return null;
    }
}
