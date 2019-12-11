package com.roland.movietheater_jdbc.controller.booking;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ReservationApiRequest {
    int seatID;
    boolean seatStatus;


}
