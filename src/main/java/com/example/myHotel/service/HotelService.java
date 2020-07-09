package com.example.myHotel.service;

import com.example.myHotel.entity.Hotel;
import com.example.myHotel.entity.Provide;

import java.util.List;
public interface HotelService {
    List<Hotel> findAll();

    List<Hotel> findByCity(String cityName);

    List<Hotel> findByStars(byte numberOfStars);

    List<Hotel> findByProvides(List<Provide> provides);

    Hotel findById(long id);

    Hotel findByName(String name);

    void save(Hotel hotel);

    void deleteById(long id);

}
