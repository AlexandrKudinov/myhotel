package com.example.myHotel.service;

import com.example.myHotel.entity.Hotel;
import com.example.myHotel.entity.Provide;

import java.util.List;

public interface ProvideService {
    List<Provide> findAll();

    List<Provide> findByHotel(Hotel hotel);

    Provide findById(long id);

    void save(Provide service);

    void deleteById(long id);
}
