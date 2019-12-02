package com.roland.movietheater_jdbc.service.RoomService;

import com.roland.movietheater_jdbc.model.Room;
import com.roland.movietheater_jdbc.repository.RoomRepository.IRoomRepositoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService implements IRoomService {


    @Autowired
    IRoomRepositoryDAO roomRepository;

    @Override
    public List<Room> findAllRooms(int cinemaId) {return roomRepository.findAllRooms(cinemaId);
    }

    @Override
    public Room createRoomInBranch(Room room) throws FailedToInsertRoomInCinemaBranchException {
     return   roomRepository.createRoomInBranch(room);
    }

    @Override
    public int deleteRoomInBranch(int cinemaId, int roomId) throws FailedToDeleteRoomInCinemaBranchException {
        return roomRepository.deleteRoomInBranch(cinemaId,roomId);
    }

    @Override
    public Room updateRoomInBranch(int cinemaId, int roomId, Room room) throws FailedToUpdateRoomInCinemaBranchException {
        return  roomRepository.updateRoomInBranch(cinemaId,roomId,room);
    }
}
