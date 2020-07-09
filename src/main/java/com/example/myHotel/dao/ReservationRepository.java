package com.example.myHotel.dao;

import com.example.myHotel.entity.Hotel;
import com.example.myHotel.entity.Person;
import com.example.myHotel.entity.Reservation;
import com.example.myHotel.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("SELECT res FROM Reservation res JOIN res.room r WHERE r.hotel = ?1")
    List<Reservation> findByHotel(Hotel hotel);

    List<Reservation> findByPerson(Person person);

    List<Reservation> findByRoom(Room room);

}
