package com.dpkrcks.hotel.service.repository;

import com.dpkrcks.hotel.service.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository< Hotel , String> {
    //Hotel Repository to Interact with the database


}
