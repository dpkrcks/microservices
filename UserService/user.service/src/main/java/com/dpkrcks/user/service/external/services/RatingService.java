package com.dpkrcks.user.service.external.services;

import com.dpkrcks.user.service.entities.Rating;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public interface RatingService {

    @GetMapping("/ratings/user/{userId}")
    List<Rating> getRatings(@PathVariable String userId);
}
