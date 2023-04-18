package com.dpkrcks.hotel.service.services.impl;

import com.dpkrcks.hotel.service.entities.Hotel;
import com.dpkrcks.hotel.service.exceptions.ResourceNotFoundException;
import com.dpkrcks.hotel.service.repository.HotelRepository;
import com.dpkrcks.hotel.service.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel saveHotel(Hotel hotel) {

        String randomId = UUID.randomUUID().toString();
        hotel.setHotelId(randomId);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotel() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotel(String hotelId) {
        return hotelRepository.findById(hotelId).orElseThrow(()-> new ResourceNotFoundException("unable to find any hotel with hotel Id : "+ hotelId));
    }

    @Override
    public Hotel updateHotel(String hotelId, Hotel hotel) {

        Hotel hotel1 = hotelRepository.findById(hotelId).get();

          hotel1.setName(hotel.getName());
          hotel1.setLocation(hotel.getLocation());
          hotel1.setAbout(hotel.getAbout());

        return hotelRepository.save(hotel1);
    }

    @Override
    public void deleteHotel(String hotelId) {
           hotelRepository.deleteById(hotelId);
    }
}
