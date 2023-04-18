package com.dpkrcks.hotel.service.controller;

import com.dpkrcks.hotel.service.entities.Hotel;
import com.dpkrcks.hotel.service.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;


//Api To save hotel
    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){

         return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.saveHotel(hotel));

    }


    //Api to get single hotel

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotel(@PathVariable String hotelId){

        return ResponseEntity.ok(hotelService.getHotel(hotelId));
    }

    //API to get all hotels

     @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotel(){

        return  ResponseEntity.ok(hotelService.getAllHotel());
    }

    //Api to update hotel

    @PostMapping("/{hotelId}")
    public ResponseEntity<Hotel> updateHotel(@PathVariable String hotelId , @RequestBody Hotel hotel){

        return ResponseEntity.ok(hotelService.updateHotel(hotelId, hotel));
    }

    //Api to delete hotel

    @DeleteMapping("/{hotelId}")
    public ResponseEntity<?> deleteHotel(@PathVariable  String hotelId){

         hotelService.deleteHotel(hotelId);
        return ResponseEntity.ok("Successfully deleted the hotel with hotel Id : "+ hotelId);
    }



}
