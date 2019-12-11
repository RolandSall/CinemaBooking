package com.roland.movietheater_jdbc.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CineMovieEventRoomSeat {

    private int cinemaId;
    private int movieEventId;
    private int seatId;
    private int roomIdOfSeat;
    private int seatRow;
    private int seatColumn;
    private int bookingId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date bookingDate;
    private boolean seatStatus;

}
