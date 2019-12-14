package com.roland.movietheater_jdbc.controller.booking;

import com.roland.movietheater_jdbc.model.CineMovieEventRoomSeat;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationListOfSeatsApiRequest {

    private List<CineMovieEventRoomSeat> seatReservationList;
}
