package com.example.myHotel.dao;

import com.example.myHotel.entity.Hotel;
import com.example.myHotel.entity.Provide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProvideRepository extends JpaRepository<Provide, Long> {
    List<Provide> findByHotel(Hotel hotel);
}
