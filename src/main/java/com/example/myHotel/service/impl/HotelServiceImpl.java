package com.example.myHotel.service.impl;

import com.example.myHotel.dao.HotelRepository;
import com.example.myHotel.entity.Hotel;
import com.example.myHotel.entity.Provide;
import com.example.myHotel.exception.HotelServiceException;
import com.example.myHotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class HotelServiceImpl implements HotelService {

    private HotelRepository hotelRepository;

    private final String EXCEPTION_MESSAGE = "Hotel not found";

    @Autowired
    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    @Override
    public List<Hotel> findByCity(String cityName) {
        return hotelRepository.findByCity(cityName);
    }

    @Override
    public List<Hotel> findByStars(byte numberOfStars) {
        return hotelRepository.findByStars(numberOfStars);
    }

    @Override
    public List<Hotel> findByProvides(List<Provide> provides) {
        return hotelRepository.findByProvides(provides);
    }

    @Override
    public Hotel findById(long id) {
        return hotelRepository.findById(id).orElseThrow(() -> new HotelServiceException(EXCEPTION_MESSAGE));
//        return hotelRepository.findById(id);
    }

    @Override
    public Hotel findByName(String name) {
        return hotelRepository.findByName(name);
    }

    @Override
    public void save(Hotel hotel) {
        hotelRepository.save(hotel);
    }

    @Override
    public void deleteById(long id) {
        hotelRepository.deleteById(id);
    }

}
