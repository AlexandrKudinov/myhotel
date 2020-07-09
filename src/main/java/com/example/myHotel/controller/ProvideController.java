package com.example.myHotel.controller;

import com.example.myHotel.entity.Provide;
import com.example.myHotel.service.ProvideService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/provides")
public class ProvideController {
    public static final Logger log = LoggerFactory.getLogger(ProvideController.class);

    private ProvideService provideService;

    @Autowired
    public ProvideController(ProvideService provideService) {
        this.provideService = provideService;
    }

    @GetMapping
    @ApiOperation(value = "get all provides")
    public List<Provide> getAllProvides() {
        log.debug("getAllProvides() started");
        List<Provide> result = provideService.findAll();
        log.debug("getAllProvides() end with result: {} ", result);
        return result;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "get provide by id")
    public Provide getProvideById(@PathVariable long id) {
        log.debug("getProvideById() started");
        Provide result = provideService.findById(id);
        log.debug("getProvideById() end with result: {} ", result);
        return result;
    }

    @PostMapping
    @ApiOperation(value = "save provide")
    public ResponseEntity<Provide> saveProvide(@RequestBody Provide provide) {
        log.debug("saveProvide() started");
        provideService.save(provide);
        log.debug("saveProvide() ended by saving room: {}", provide);
        return ResponseEntity.status(201).body(provide);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "delete provide")
    public ResponseEntity<Long> deleteProvide(@PathVariable long id) {
        log.debug("deleteProvide() started");
        provideService.deleteById(id);
        log.debug("deleteProvide() ended by deleting provide with id: {} ", id);
        return ResponseEntity.ok().body(id);
    }
}
