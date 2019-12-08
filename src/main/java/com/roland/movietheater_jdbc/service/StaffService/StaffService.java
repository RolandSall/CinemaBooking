package com.roland.movietheater_jdbc.service.StaffService;

import com.roland.movietheater_jdbc.model.Staff;
import com.roland.movietheater_jdbc.repository.StaffRepository.StaffRepositoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService implements IStaffService {

    private StaffRepositoryDAO staffRepository;

    @Autowired
    public StaffService(StaffRepositoryDAO staffRepository) {

        this.staffRepository = staffRepository;
    }

    @Override
    public List<Staff> findAllStaffInBranch(int cinemaId) {
        return  staffRepository.findAllStaffInBranch(cinemaId);
    }

    @Override
    public Staff createStaffInCinemaBranch(int cinemaId, Staff staff) throws FailedToCreateStaffInCinemaBranch {
        return  staffRepository.createStaffInCinemaBranch(cinemaId,staff);
    }

    @Override
    public String deleteStaffInCinemaBranch(int cinemaId, int staffId) throws FailedToDeleteStaffInCinemaBranch {
        return  staffRepository.deleteStaffInCinemaBranch(cinemaId,staffId);
    }

    @Override
    public Staff updateStaffInCinemaBranch(int cinemaId, int staffId, Staff staff) throws FailedToUpdateStaffInCinemaBranch {
        return  staffRepository.updateStaffInCinemaBranch(cinemaId,staffId, staff);
    }
}
