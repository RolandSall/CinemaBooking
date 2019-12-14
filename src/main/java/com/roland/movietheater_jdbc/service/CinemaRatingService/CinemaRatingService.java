package com.roland.movietheater_jdbc.service.CinemaRatingService;


import com.roland.movietheater_jdbc.model.CinemaRatingForm;
import com.roland.movietheater_jdbc.repository.CinemaRatingRepository.CinemaRatingRepositoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaRatingService implements ICinemaRatingService {


    private CinemaRatingRepositoryDAO cinemaRatingRepositoryDAO;

    @Autowired
    public CinemaRatingService(CinemaRatingRepositoryDAO cinemaRatingRepositoryDAO) {
        this.cinemaRatingRepositoryDAO = cinemaRatingRepositoryDAO;
    }

    @Override
    public List<CinemaRatingForm> getAllRatingForCinemaBranchById(int cinemaId) {
        return cinemaRatingRepositoryDAO.getAllRatingForCinemaBranchById(cinemaId);
    }

    @Override
    public CinemaRatingForm createRatingFormForCinemaBranch(CinemaRatingForm cinemaFormRating) {
        return cinemaRatingRepositoryDAO.createRatingFormForCinemaBranch(cinemaFormRating);
    }

    @Override
    public String deleteRatingFormForCinemaBranchByCustomer(int cinemaId, int customerId, int cinemaRatingId) {
        return cinemaRatingRepositoryDAO.deleteRatingFormForCinemaBranchByCustomer(cinemaId,customerId,cinemaRatingId);
    }

    @Override
    public double getAverageRatingForCinemaBranchById(int cinemaId) {
        return cinemaRatingRepositoryDAO.getAverageRatingForCinemaBranchById(cinemaId);
    }
}
