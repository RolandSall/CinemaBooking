package com.roland.movietheater_jdbc.repository.CinemaRatingRepository;


import com.roland.movietheater_jdbc.model.CinemaRatingForm;

import java.util.List;

public interface ICinemaRatingRepositoryDAO {


    List<CinemaRatingForm> getAllRatingForCinemaBranchById(int cinemaId);

    CinemaRatingForm createRatingFormForCinemaBranch(CinemaRatingForm cinemaFormRating);

    String deleteRatingFormForCinemaBranchByCustomer(int cinemaId, int customerId, int cinemaRatingId);

    double getAverageRatingForCinemaBranchById(int cinemaId);
}
