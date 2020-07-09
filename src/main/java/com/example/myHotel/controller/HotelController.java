package com.example.myHotel.controller;

import com.example.myHotel.entity.Hotel;
import com.example.myHotel.service.HotelService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    public static final Logger log = LoggerFactory.getLogger(HotelController.class);

    private HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
    @ApiOperation(value = "get all reservation")
    public List<Hotel> getAllHotels() {
        log.debug("getAllHotels() started");
        List<Hotel> result = hotelService.findAll();
        log.debug("getAllHotels() end with result: {} ", result);
        return result;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "get hotel by id")
    public Hotel getHotelById(@PathVariable long id) {
        log.debug("getProvideById() started");
        Hotel result = hotelService.findById(id);
        log.debug("getReservationById() end with result: {} ", result);
        return result;
    }

    @PostMapping
    @ApiOperation(value = "save hotel")
    public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel) {
        log.debug("saveHotel() started");
        hotelService.save(hotel);
        log.debug("saveHotel() ended by saving hotel: {}", hotel);
        return ResponseEntity.status(201).body(hotel);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "delete hotel")
    public ResponseEntity<Long> deleteHotel(@PathVariable long id) {
        log.debug("deleteHotel() started");
        hotelService.deleteById(id);
        log.debug("deleteHotel() ended by deleting hotel with id: {} ", id);
        return ResponseEntity.ok().body(id);
    }
}
