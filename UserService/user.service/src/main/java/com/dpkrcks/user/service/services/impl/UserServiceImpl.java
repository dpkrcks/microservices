package com.dpkrcks.user.service.services.impl;

import com.dpkrcks.user.service.entities.Hotel;
import com.dpkrcks.user.service.entities.Rating;
import com.dpkrcks.user.service.entities.User;
import com.dpkrcks.user.service.exceptions.ResourceNotFoundException;
import com.dpkrcks.user.service.external.services.HotelService;
import com.dpkrcks.user.service.external.services.RatingService;
import com.dpkrcks.user.service.repository.UserRepository;
import com.dpkrcks.user.service.services.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;


//    @Autowired
//    private RatingService ratingService;
//
//    @Autowired
//    private HotelService hotelService;


    //for logging info

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


    @Override
    public User saveUser(User user) {

        String random = UUID.randomUUID().toString();
        user.setUserId(random);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {

        //code to fetch all the users with all ratings and hotels associated

        List<User> users = userRepository.findAll();

        List<User> finalUsers = users.stream().map(user -> {

            Rating[] forObject = restTemplate.getForObject("http://RATING-SERVICES/ratings/user/" + user.getUserId(), Rating[].class);

            List<Rating>  ratings = Arrays.stream(forObject).toList();
           // List<Rating> ratings = ratingService.getRatings(user.getUserId());

            List<Rating> finalRating = ratings.stream().map(rating -> {

                //Hotel hotel = hotelService.getHotel(rating.getHotelId());

                ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICES/hotels/" + rating.getHotelId(), Hotel.class);

                Hotel hotel = forEntity.getBody();

                rating.setHotel(hotel);

                return rating;

            }).collect(Collectors.toList());

            user.setRatings(finalRating);
            return user;
        }).collect(Collectors.toList());


        return finalUsers;
    }

    @Override
    public User getUser(String userId) {

        //here we will call the rating service to get the ratings given by the user with userId
        //we will use Rest Template class to make call to the rating service

        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User could not be found with userId :" + userId));

        //calling rating services

        Rating[] forObject = restTemplate.getForObject("http://RATING-SERVICES/ratings/user/" + userId, Rating[].class);

        List<Rating> ratings = Arrays.stream(forObject).toList();

        logger.info(" {}" , ratings);

        List<Rating> finalRatings = ratings.stream().map(rating -> {

            ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICES/hotels/" + rating.getHotelId(), Hotel.class);

            Hotel hotel = forEntity.getBody();

            rating.setHotel(hotel);

            return rating;

        }).collect(Collectors.toList());

        user.setRatings(finalRatings);

        return user;
    }

    @Override
    public void deleteUser(String userId) {

        userRepository.deleteById(userId);
    }

    @Override
    public User updateUser(String userId , User user) {

        User user1 = userRepository.findById(userId).get();

          user1.setName(user.getName());
          user1.setEmail(user.getEmail());
          user1.setAbout(user.getAbout());
          user1.setRatings(user.getRatings());

        User updatedUser = userRepository.save(user1);

        return updatedUser;
    }
}
