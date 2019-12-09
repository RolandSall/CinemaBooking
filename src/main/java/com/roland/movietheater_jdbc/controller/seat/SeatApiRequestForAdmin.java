package com.roland.movietheater_jdbc.controller.seat;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class SeatApiRequestForAdmin {
    private int seatRow;
    private int seatColumn;
    private boolean seatStatus;


}
