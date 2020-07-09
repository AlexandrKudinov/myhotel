package com.example.myHotel.service.impl;

import com.example.myHotel.dao.ReservationRepository;
import com.example.myHotel.entity.Person;
import com.example.myHotel.entity.Reservation;
import com.example.myHotel.entity.Room;
import com.example.myHotel.exception.HotelServiceException;
import com.example.myHotel.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {

    private ReservationRepository reservationRepository;

    private final String EXCEPTION_MESSAGE = "Reservation not found";

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @Override
    public List<Reservation> findByRoom(Room room) {
        return reservationRepository.findByRoom(room);
    }

    @Override
    public List<Reservation> findByPerson(Person person) {
        return reservationRepository.findByPerson(person);
    }

    @Override
    public Reservation findById(long id) {
        return reservationRepository.findById(id).orElseThrow(() -> new HotelServiceException(EXCEPTION_MESSAGE));
    }

    @Override
    public void save(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    @Override
    public void deleteById(long id) {
        reservationRepository.deleteById(id);
    }
}
