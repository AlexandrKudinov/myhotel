package com.example.myHotel.controller;

import com.example.myHotel.entity.Reservation;
import com.example.myHotel.service.ReservationService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    public static final Logger log = LoggerFactory.getLogger(ReservationController.class);

    private ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    @ApiOperation(value = "get all reservation")
    public List<Reservation> getAllReservations() {
        log.debug("getAllReservations() started");
        List<Reservation> result = reservationService.findAll();
        log.debug("getAllReservations() end with result: {} ", result);
        return result;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "get reservation by id")
    public Reservation getReservationById(@PathVariable long id) {
        log.debug("getProvideById() started");
        Reservation result = reservationService.findById(id);
        log.debug("getReservationById() end with result: {} ", result);
        return result;
    }

    @PostMapping
    @ApiOperation(value = "save reservation")
    public ResponseEntity<Reservation> saveReservation(@RequestBody Reservation reservation) {
        log.debug("saveReservation() started");
        reservationService.save(reservation);
        log.debug("saveReservation() ended by saving room: {}", reservation);
        return ResponseEntity.status(201).body(reservation);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "delete reservation")
    public ResponseEntity<Long> deleteReservation(@PathVariable long id) {
        log.debug("deleteReservation() started");
        reservationService.deleteById(id);
        log.debug("deleteReservation() ended by deleting provide with id: {} ", id);
        return ResponseEntity.ok().body(id);
    }
}
