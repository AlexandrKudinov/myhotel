package com.example.myHotel.service;

import com.example.myHotel.entity.Person;
import com.example.myHotel.entity.Reservation;
import com.example.myHotel.entity.Room;

import java.util.List;

public interface ReservationService {
    List<Reservation> findAll();

    List<Reservation> findByRoom(Room room);

    List<Reservation> findByPerson(Person person);

    Reservation findById(long id);

    void save(Reservation reservation);

    void deleteById(long id);
}
