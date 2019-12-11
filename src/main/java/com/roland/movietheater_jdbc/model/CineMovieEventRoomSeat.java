package com.roland.movietheater_jdbc.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CineMovieEventRoomSeat {
    int cinemaId;
    int movieEventId;
    int seatId;
    int roomIdOfSeat;
    int seatRow;
    int seatColumn;


}
