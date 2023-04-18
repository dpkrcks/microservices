package com.dpkrcks.rating.service.RatingService.services;

import com.dpkrcks.rating.service.RatingService.entities.Rating;

import java.util.List;

public interface RatingService {

    //create rating
    public Rating saveRating(Rating rating);

    //getAllRatings
    public List<Rating> getAllRating();

    //get a single rating
    public Rating getRating(String ratingId);

    //get a rating using user ID
    public List<Rating> getRatingByUserId(String userId);

    //get a rating using hotel Id
    public List<Rating> getRatingByHotelId(String hotelId);

    //delete a rating
    public void deleteRating(String ratingId);

    //update a rating
    public Rating updateRating(String ratingId , Rating rating);
}
