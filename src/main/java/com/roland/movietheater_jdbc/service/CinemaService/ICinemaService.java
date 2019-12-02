package com.roland.movietheater_jdbc.service.CinemaService;

import com.roland.movietheater_jdbc.model.CinemaBranch;

import java.util.List;

public interface ICinemaService {

     List<CinemaBranch> findAllCinemaBranch();

     CinemaBranch createCinemaBranch(CinemaBranch cinemaBranch) throws FailedToInsertCinemaException;

     int deleteCinemaBranch(int cinemaId) throws FailedToDeleteCinemaException;

     CinemaBranch updateCinemaBranch(int  cinemaId, CinemaBranch cinemaBranch) throws FailedToUpdateCinemaException;
}
