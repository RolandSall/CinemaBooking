package com.roland.movietheater_jdbc.service.CinemaRatingService;

import com.roland.movietheater_jdbc.model.CinemaRatingForm;

import java.util.List;

public interface ICinemaRatingService {
    List<CinemaRatingForm> getAllRatingForCinemaBranchById(int cinemaId);

    CinemaRatingForm createRatingFormForCinemaBranch(CinemaRatingForm cinemaFormRating);

    String deleteRatingFormForCinemaBranchByCustomer(int cinemaId, int customerId, int cinemaRatingId);

    double getAverageRatingForCinemaBranchById(int cinemaId);
}
