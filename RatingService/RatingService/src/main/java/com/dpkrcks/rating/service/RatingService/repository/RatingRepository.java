package com.dpkrcks.rating.service.RatingService.repository;

import com.dpkrcks.rating.service.RatingService.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, String> {

    //Repository to interact with the database

    //custom methods

    List<Rating> findByUserId(String userId);
    List<Rating> findByHotelId(String hotelId);

}
