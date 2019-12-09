package com.roland.movietheater_jdbc.controller.seat;

import com.roland.movietheater_jdbc.model.Seat;
import com.roland.movietheater_jdbc.service.RoomService.FailedToFindRoomInCinemaBranchException;
import com.roland.movietheater_jdbc.service.SeatService.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SeatController {

    private SeatService seatService;

    @Autowired
    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping("/admin/cinemas/{cinemaId}/rooms/{roomId}/seats")
    public ResponseEntity getAllSeatsInRoomForAdmin(@PathVariable("cinemaId") int cinemaId,
                                                    @PathVariable("roomId") int roomId) {

        List<Seat> seatList = seatService.getAllSeatsInRoomForAdmin(cinemaId, roomId);
        List<SeatApiResponseForAdmin> responseList = buildSeatListResponseForAdmin(seatList);
        return ResponseEntity.status(HttpStatus.OK).body(responseList);
    }


    @GetMapping("cinemas/{cinemaId}/rooms/{roomId}/seats")
    public ResponseEntity getAllSeatsInRoomForUser(@PathVariable("cinemaId") int cinemaId,
                                                   @PathVariable("roomId") int roomId) {

        List<Seat> seatList = seatService.getAllSeatsInRoomForUser(cinemaId, roomId);
        List<SeatApiResponseForAdmin> responseList = buildSeatListResponseForAdmin(seatList);
        return ResponseEntity.status(HttpStatus.OK).body(responseList);
    }


    @GetMapping("/admin/cinemas/{cinemaId}/rooms/{roomId}/seats/{seatId}")
    public ResponseEntity getSeatInRoomById(@PathVariable("cinemaId") int cinemaId,
                                            @PathVariable("roomId") int roomId,
                                            @PathVariable("seatId") int seatId) {

        try {
            Seat seat = seatService.getSeatInRoomById(cinemaId, roomId, seatId);
            SeatApiResponseForAdmin response = getSeatApiResponseForAdmin(seat);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (FailedToFindSeatInCinemaBranchRoom e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getLocalizedMessage());
        }

    }


/*    @DeleteMapping("/admin/cinemas/{cinemaId}/rooms/{roomId}/seats/{seatId}")
    public ResponseEntity deleteSeatInRoom(@PathVariable("cinemaId") int cinemaId,
                                           @PathVariable("roomId") int roomId,
                                           @PathVariable("seatId") int seatId) {

        try {
            int seatIdDeleted = seatService.deleteSeatInRoom(cinemaId, roomId, seatId);
            return ResponseEntity.status(HttpStatus.OK).body(seatIdDeleted);
        } catch (FailedToDeleteSeatInCinemaBranchRoom e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }*/


    @DeleteMapping("/admin/cinemas/{cinemaId}/rooms/{roomId}/seats")
    public ResponseEntity deleteAllSeatsInRoom(@PathVariable("cinemaId") int cinemaId,
                                               @PathVariable("roomId") int roomId) {

        try {
            String seatIdDeleted = seatService.deleteAllSeatsInRoom(cinemaId, roomId);
            return ResponseEntity.status(HttpStatus.OK).body(seatIdDeleted);
        } catch (FailedToDeleteSeatInCinemaBranchRoom e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getLocalizedMessage());
        }
    }


    @PostMapping("/admin/cinemas/{cinemaId}/rooms/{roomId}/{roomCapacity}/seats")
    public ResponseEntity createSeatInRoom(@PathVariable("cinemaId") int cinemaId,
                                           @PathVariable("roomId") int roomId,
                                           @PathVariable("roomCapacity") int roomCapacity,
                                           @RequestBody SeatApiRequestForAdmin request) {

        try {
            List<Seat> seatList = seatService.createSeatInRoom(cinemaId, roomId,roomCapacity,getSeat(request));
            List<SeatApiResponseForAdmin> responseList = buildSeatListResponseForAdmin(seatList);
            return ResponseEntity.status(HttpStatus.OK).body(responseList);
        } catch (FailedToCreateSeatInCinemaBranchRoom e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }

    }

    @PutMapping("cinemas/{cinemaId}/rooms/{roomId}/seats/{seatId}")
    public ResponseEntity reserveSeatInRoom(@PathVariable("cinemaId") int cinemaId,
                                            @PathVariable("roomId") int roomId,
                                            @PathVariable("seatId") int seatId,
                                            @RequestBody SeatApiRequestForUser request) {

        try {

            Seat seat = seatService.reserveSeatInRoom(cinemaId, roomId, seatId, getSeat(request));
            SeatApiResponseForUser response = getSeatApiResponseForUser(seat);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (FailedToReserveSeatInCinemaBranch e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }

    }


    @PutMapping("/admin/cinemas/{cinemaId}/rooms/{roomId}/seats/{seatId}")
    public ResponseEntity updateSeatInRoom(@PathVariable("cinemaId") int cinemaId,
                                           @PathVariable("roomId") int roomId,
                                           @PathVariable("seatId") int seatId,
                                           @RequestBody SeatApiRequestForAdmin request) {

        try {
            Seat seat = seatService.updateSeatInRoom(cinemaId, roomId, seatId, getSeat(request));
            SeatApiResponseForAdmin response = getSeatApiResponseForAdmin(seat);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (FailedToUpdateSeatInCinemaBranchRoom e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getLocalizedMessage());
        }
    }


    private Seat getSeat(SeatApiRequestForAdmin request) {
        return new Seat().builder()
                .seatStatus(request.isSeatStatus())
                .build();
    }

    private Seat getSeat(SeatApiRequestForUser request) {
        return new Seat().builder()
                .seatStatus(request.isSeatStatus())
                .build();
    }


    private List<SeatApiResponseForAdmin> buildSeatListResponseForAdmin(List<Seat> seatList) {
        List<SeatApiResponseForAdmin> responseList = new ArrayList<>();
        for (Seat seat : seatList) {
            responseList.add(getSeatApiResponseForAdmin(seat));
        }

        return responseList;
    }

    private SeatApiResponseForAdmin getSeatApiResponseForAdmin(Seat seat) {
        return new SeatApiResponseForAdmin().builder()
                .roomId(seat.getRoomId())
                .seatId(seat.getSeatId())
                .seatRow(seat.getSeatRow())
                .seatColumn(seat.getSeatColumn())
                .seatStatus(seat.isSeatStatus())
                .build();

    }

    private SeatApiResponseForUser getSeatApiResponseForUser(Seat seat) {
        return new SeatApiResponseForUser().builder()
                .seatStatus(seat.isSeatStatus())
                .build();
    }


}
