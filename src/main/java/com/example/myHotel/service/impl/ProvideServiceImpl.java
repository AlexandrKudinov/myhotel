package com.example.myHotel.service.impl;

import com.example.myHotel.dao.ProvideRepository;
import com.example.myHotel.entity.Hotel;
import com.example.myHotel.entity.Provide;
import com.example.myHotel.exception.HotelServiceException;
import com.example.myHotel.service.ProvideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
public class ProvideServiceImpl implements ProvideService {

    private ProvideRepository provideRepository;

    private final String EXCEPTION_MESSAGE = "Provide not found";

    @Autowired
    public ProvideServiceImpl(ProvideRepository provideRepository) {
        this.provideRepository = provideRepository;
    }

    @Override
    public List<Provide> findAll() {
        return provideRepository.findAll();
    }

    @Override
    public List<Provide> findByHotel(Hotel hotel) {
        return provideRepository.findByHotel(hotel);
    }

    @Override
    public Provide findById(long id) {
        return provideRepository.findById(id).orElseThrow(() -> new HotelServiceException(EXCEPTION_MESSAGE));
    }

    @Override
    public void save(Provide provide) {
        provideRepository.save(provide);
    }

    @Override
    public void deleteById(long id) {
        provideRepository.deleteById(id);
    }
}
