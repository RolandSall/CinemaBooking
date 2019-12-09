package com.roland.movietheater_jdbc.controller.seat;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class SeatApiRequestForUser {
    private boolean seatStatus;
}
