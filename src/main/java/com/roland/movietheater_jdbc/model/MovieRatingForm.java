package com.roland.movietheater_jdbc.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieRatingForm {
    private  int customerId;
    private  String cinemaId;
    private int movieReviewRating;
    private String movieReviewComment;
}
