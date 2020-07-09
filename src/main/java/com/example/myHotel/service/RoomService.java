package com.example.myHotel.service;

import com.example.myHotel.entity.Room;

import java.util.List;

public interface RoomService {
    List<Room> findAll();

    Room findById(long id);

    void save(Room room);

    void deleteById(long id);
}
