package com.roland.movietheater_jdbc.controller.movieRating;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieRatingApiRequestForAdminAndUser {
    private  int customerId;
    private  int movieId;
    private String customerUserName;
    private double movieReviewRating;
    private String movieReviewComment;
}
