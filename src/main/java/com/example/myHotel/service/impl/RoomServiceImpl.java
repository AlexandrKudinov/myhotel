package com.example.myHotel.service.impl;

import com.example.myHotel.dao.RoomRepository;
import com.example.myHotel.entity.Room;
import com.example.myHotel.exception.HotelServiceException;
import com.example.myHotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoomServiceImpl implements RoomService {

    private RoomRepository roomRepository;

    private final String EXCEPTION_MESSAGE = "Room not found";

    @Autowired
    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    @Override
    public Room findById(long id) {
        return roomRepository.findById(id).orElseThrow(() -> new HotelServiceException(EXCEPTION_MESSAGE));
    }

    @Override
    public void save(Room room) {
        roomRepository.save(room);
    }

    @Override
    public void deleteById(long id) {
        roomRepository.deleteById(id);
    }
}
