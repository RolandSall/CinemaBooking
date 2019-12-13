package com.roland.movietheater_jdbc.controller.booking;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationApiResponseForUser {
    private int customerId;
    private String customerUsername;
    private String movieName;
    private String cinemaAddress;
    private String roomName;
    private int seatRow;
    private int seatColumn;
    private double ticketPrice;
}
