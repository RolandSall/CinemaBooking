package com.roland.movietheater_jdbc.controller.booking;

import com.roland.movietheater_jdbc.model.CineMovieEvent;
import com.roland.movietheater_jdbc.model.CineMovieEventRoomSeat;
import com.roland.movietheater_jdbc.model.CineMovieEventRoomTiming;
import com.roland.movietheater_jdbc.service.BookingService.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
public class BookingController {

    public BookingService bookingService;

    @Autowired
    public  BookingController(BookingService bookingService){
    this.bookingService = bookingService;
    }


    @GetMapping("/booking/movies/{movieId}")
    public ResponseEntity getCinemaBranchHostingMovieById(@PathVariable("movieId") int movieId) {
        List<CineMovieEvent>  cineMovieEventList = bookingService.getCinemaBranchHostingByMovieId(movieId);
        List<CineMovieEventApiResponseForUser> responseList = buildCinemaBranchHostingByIdResponse(cineMovieEventList);
        return ResponseEntity.status(HttpStatus.OK).body(responseList);

    }

    @GetMapping("/booking/movies/{movieId}/cinemas/{cinemaId}")
    public ResponseEntity getRoomTimingHostingMovieByMovieIdAndCinemaId(@PathVariable("movieId") int movieId, @PathVariable("cinemaId") int cinemaId){
        List<CineMovieEventRoomTiming> cineMovieEventRoomTimingList = bookingService.getRoomTimingHostingMovieByMovieIdAndCinemaId(movieId,cinemaId);
        List<CineMovieEventRoomTimingApiResponseForUser> responseList = buildRoomTimingForMovieEventInBranch(cineMovieEventRoomTimingList);
        return ResponseEntity.status(HttpStatus.OK).body(responseList);
    }

    @GetMapping("/booking/movies/{movieId}/cinemas/{cinemaId}/rooms/{roomId}")
    public ResponseEntity getSeatsAvailableForMovieEvent(@PathVariable("movieId") int movieId,
                                                         @PathVariable("cinemaId") int cinemaId, @PathVariable("roomId") int roomId){

        List<CineMovieEventRoomSeat> cineMovieEventRoomSeatList = bookingService.getSeatsAvailableForMovieEvent(movieId,cinemaId,roomId);
        List<CineMovieEventRoomSeatApiResponseForUser> responseList = getSeatsAvailableForMovieEventApiResponse(cineMovieEventRoomSeatList);
        return ResponseEntity.status(HttpStatus.OK).body(responseList);
    }

    @PostMapping("/booking/movies/{movieId}/cinemas/{cinemaId}/rooms/{roomId}")

    private List<CineMovieEventRoomSeatApiResponseForUser> getSeatsAvailableForMovieEventApiResponse(List<CineMovieEventRoomSeat> cineMovieEventRoomSeatList) {
        List<CineMovieEventRoomSeatApiResponseForUser> responseList = new ArrayList<>();
        for (CineMovieEventRoomSeat cineMovieEventRoomSeat : cineMovieEventRoomSeatList) {
            responseList.add(getSeatsAvailableForMovieEvent(cineMovieEventRoomSeat));
        }

        return responseList;
    }

    private CineMovieEventRoomSeatApiResponseForUser getSeatsAvailableForMovieEvent(CineMovieEventRoomSeat cineMovieEventRoomSeat) {
        return  new CineMovieEventRoomSeatApiResponseForUser().builder()
                .cinemaId(cineMovieEventRoomSeat.getCinemaId())
                .movieEventId(cineMovieEventRoomSeat.getMovieEventId())
                .seatId(cineMovieEventRoomSeat.getSeatId())
                .roomIdOfSeat(cineMovieEventRoomSeat.getRoomIdOfSeat())
                .seatRow(cineMovieEventRoomSeat.getSeatRow())
                .seatStatus(cineMovieEventRoomSeat.isSeatStatus())
                .build();

    }


    private List<CineMovieEventRoomTimingApiResponseForUser> buildRoomTimingForMovieEventInBranch(List<CineMovieEventRoomTiming> cineMovieEventRoomTimingList) {
        List<CineMovieEventRoomTimingApiResponseForUser> responseList = new ArrayList<>();
        for (CineMovieEventRoomTiming cineMovieEventRoomTiming : cineMovieEventRoomTimingList) {
            responseList.add(getRoomTimingForMovieEventInBranch(cineMovieEventRoomTiming));
        }

        return responseList;
    }



    private CineMovieEventRoomTimingApiResponseForUser getRoomTimingForMovieEventInBranch(CineMovieEventRoomTiming cineMovieEventRoomTiming) {
        return new CineMovieEventRoomTimingApiResponseForUser().builder()
                .cinemaId(cineMovieEventRoomTiming.getCinemaId())
                .movieId(cineMovieEventRoomTiming.getMovieId())
                .room_id(cineMovieEventRoomTiming.getRoom_id())
                .movieEventId(cineMovieEventRoomTiming.getMovieEventId())
                .movieStartTime(cineMovieEventRoomTiming.getMovieStartTime())
                .movieEndTime(cineMovieEventRoomTiming.getMovieEndTime())
                .build();
    }


    private List<CineMovieEventApiResponseForUser> buildCinemaBranchHostingByIdResponse(List<CineMovieEvent> cineMovieEventList) {
        List<CineMovieEventApiResponseForUser> responseList = new ArrayList<>();
        for (CineMovieEvent cineMovieEvent : cineMovieEventList) {
            responseList.add(getCinemaBranchHostingByIdResponse(cineMovieEvent));
        }

        return responseList;
    }

    private CineMovieEventApiResponseForUser getCinemaBranchHostingByIdResponse(CineMovieEvent cineMovieEvent) {
        return  new CineMovieEventApiResponseForUser().builder()
                .cinemaId(cineMovieEvent.getCinemaId())
                .movieId(cineMovieEvent.getMovieId())
                .cinemaName(cineMovieEvent.getCinemaName())
                .cinemaAddress(cineMovieEvent.getCinemaAddress())
                .cinemaPhone(cineMovieEvent.getCinemaPhone())
                .build();
    }

}
