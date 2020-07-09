package com.example.myHotel.dao;

import com.example.myHotel.entity.Hotel;
import com.example.myHotel.entity.Provide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    List<Hotel> findByCity(String string);

    List<Hotel> findByStars(byte numberOfStars);

    @Query("SELECT h FROM Hotel h WHERE h.provides = :prov")
    List<Hotel> findByProvides(@Param("prov") List<Provide> provides);

    Hotel findByName(String name);
}
