package com.example.myHotel.controller;

import com.example.myHotel.entity.Room;
import com.example.myHotel.service.RoomService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    public static final Logger log = LoggerFactory.getLogger(RoomController.class);

    private RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }


    @GetMapping
    @ApiOperation(value = "get all rooms")
    public List<Room> getAllRooms() {
        log.debug("getAllRooms() started");
        List<Room> result = roomService.findAll();
        log.debug("getAllRooms() end with result: {} ", result);
        return result;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "get person by id")
    public Room getRoomById(@PathVariable long id) {
        log.debug("getRoomById() started");
        Room result = roomService.findById(id);
        log.debug("getRoomById() end with result: {} ", result);
        return result;
    }

    @PostMapping
    @ApiOperation(value = "save person")
    public ResponseEntity<Room> saveRoom(@RequestBody Room room) {
        log.debug("saveRoom() started");
        roomService.save(room);
        log.debug("saveRoom() ended by saving room: {}", room);
        return ResponseEntity.status(201).body(room);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "delete person")
    public ResponseEntity<Long> deleteRoom(@PathVariable long id) {
        log.debug("deleteRoom() started");
        roomService.deleteById(id);
        log.debug("deleteRoom() ended by deleting room with id: {} ", id);
        return ResponseEntity.ok().body(id);
    }
}
