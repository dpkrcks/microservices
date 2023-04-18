package com.dpkrcks.hotel.service.services;

import com.dpkrcks.hotel.service.entities.Hotel;

import java.util.List;

public interface HotelService {

    //Create Hotel
    public Hotel saveHotel(Hotel hotel);

    //fetch all hotels
    public List<Hotel> getAllHotel();

    //fetch a single hotel
    public Hotel getHotel(String hotelId);

    //update a hotel
    public Hotel updateHotel(String hotelId , Hotel hotel);

    //delete a hotel
    public void deleteHotel(String hotelId);
}
