package com.roland.movietheater_jdbc.model;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ticket {
    private int tickedId;
    private Date tickedDate;
    private int ticketPrice;
    private int numberOfParticipants;
    private int customerId;
    private List<Seat> seatReservedList;


}
