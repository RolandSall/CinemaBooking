package com.roland.movietheater_jdbc.controller.booking;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CineMovieEventRoomSeatApiResponseForUser {
    int cinemaId;
    int movieEventId;
    int seatId;
    int roomIdOfSeat;
    int seatRow;
    boolean seatStatus;

}
