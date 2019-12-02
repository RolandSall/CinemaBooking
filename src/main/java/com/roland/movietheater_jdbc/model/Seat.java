package com.roland.movietheater_jdbc.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Seat {
    private  String seatId;
    private  int seatRow;
    private boolean seatStatus;
    private String roomId;
    private int ticketId;
    private Date ticketDate;
}
