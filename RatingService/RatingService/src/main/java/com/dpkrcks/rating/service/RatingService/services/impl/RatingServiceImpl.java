package com.dpkrcks.rating.service.RatingService.services.impl;

import com.dpkrcks.rating.service.RatingService.entities.Rating;
import com.dpkrcks.rating.service.RatingService.exceptions.ResourceNotFoundException;
import com.dpkrcks.rating.service.RatingService.repository.RatingRepository;
import com.dpkrcks.rating.service.RatingService.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating saveRating(Rating rating) {

        String randomId = UUID.randomUUID().toString();

        rating.setRatingId(randomId);
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRating() {
        return ratingRepository.findAll();
    }

    @Override
    public Rating getRating(String ratingId) {
        return ratingRepository.findById(ratingId).orElseThrow(()-> new ResourceNotFoundException("Rating can not be found with rating Id :"+ ratingId));
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }

    @Override
    public void deleteRating(String ratingId) {
        ratingRepository.deleteById(ratingId);
    }

    @Override
    public Rating updateRating(String ratingId, Rating rating) {

        Rating rating1 = ratingRepository.findById(ratingId).get();

        rating1.setRating(rating.getRating());
        rating1.setFeedback(rating.getFeedback());
        rating1.setUserId(rating.getUserId());
        rating1.setHotelId(rating.getHotelId());

        return ratingRepository.save(rating1);
    }
}
