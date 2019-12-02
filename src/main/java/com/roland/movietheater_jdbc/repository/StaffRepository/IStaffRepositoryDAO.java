package com.roland.movietheater_jdbc.repository.StaffRepository;

import com.roland.movietheater_jdbc.model.Staff;
import com.roland.movietheater_jdbc.service.StaffService.FailedToCreateStaffInCinemaBranch;
import com.roland.movietheater_jdbc.service.StaffService.FailedToDeleteStaffInCinemaBranch;

import java.util.List;

public interface IStaffRepositoryDAO {

    List<Staff> findAllStaffInBranch(int cinemaId);

    Staff createStaffInCinemaBranch(int cinemaId, Staff staff) throws FailedToCreateStaffInCinemaBranch;

    String deleteStaffInCinemaBranch(int cinemaId, int staffId) throws FailedToDeleteStaffInCinemaBranch;
}
