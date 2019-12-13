package com.roland.movietheater_jdbc.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Reservation {
    private int customerId;
    private String customerUsername;
    private String movieName;
    private String cinemaAddress;
    private String roomName;
    private int seatRow;
    private int seatColumn;
    private double ticketPrice;
}
