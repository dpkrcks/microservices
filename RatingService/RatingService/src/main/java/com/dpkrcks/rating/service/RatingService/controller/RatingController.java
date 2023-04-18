package com.dpkrcks.rating.service.RatingService.controller;

import com.dpkrcks.rating.service.RatingService.entities.Rating;
import com.dpkrcks.rating.service.RatingService.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    //create Rating

    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){

        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.saveRating(rating));
    }

    //fetch a rating

    @GetMapping("/{ratingId}")
    public ResponseEntity<Rating> getRating(@PathVariable String ratingId){

        return ResponseEntity.ok(ratingService.getRating(ratingId));
    }

    //fetch all ratings

    @GetMapping
    public ResponseEntity<List<Rating>> getAllRating(){

        return ResponseEntity.ok(ratingService.getAllRating());
    }

    //fetch all ratings by user Id


    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Rating>> getAllRatingByUserId(@PathVariable String userId){

        return ResponseEntity.ok(ratingService.getRatingByUserId(userId));
    }

    //fetch all ratings by hotel Id

    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<Rating>> getAllRatingByHotelId(@PathVariable String hotelId){

        return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));
    }

    //delete a rating

    @DeleteMapping("/{ratingId}")
    public ResponseEntity<?> deleteRating(@PathVariable String ratingId){

        ratingService.deleteRating(ratingId);
        return ResponseEntity.ok("Rating is deleted successfully with rating Id :" + ratingId);
    }


    //update a rating

    @PostMapping("/{ratingId}")
    public ResponseEntity<Rating> updateRating(@PathVariable String ratingId , @RequestBody Rating rating){

        return ResponseEntity.ok(ratingService.updateRating(ratingId , rating));
    }


}
