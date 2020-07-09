package com.example.myHotel.controller;

import com.example.myHotel.entity.Person;
import com.example.myHotel.service.PersonService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/persons")
public class PersonController {

    private PersonService personService;

    private static final Logger log = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    @ApiOperation(value = "get all persons")
    public List<Person> getAllPersons() {
        log.debug("getAllPersons() started");
        List<Person> result = personService.findAll();
        log.debug("getAllPersons() end with result: {} ", result);
        return result;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "get person by id")
    public Person getPersonById(@PathVariable long id) {
        log.debug("getPersonById() started");
        Person result = personService.findById(id);
        log.debug("getPersonById() end with result: {} ", result);
        return result;
    }

    @PostMapping
    @ApiOperation(value = "save person")
    public ResponseEntity<Person> savePerson(@RequestBody Person person) {
        log.debug("savePerson() started");
        personService.save(person);
        log.debug("savePerson() ended by saving person: {}", person);
        return ResponseEntity.status(201).body(person);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "delete person")
    public ResponseEntity<Long> deletePerson(@PathVariable long id) {
        log.debug("deletePerson() started");
        personService.deleteById(id);
        log.debug("deletePerson() ended by deleting person with id: {} ", id);
        return ResponseEntity.ok().body(id);
    }

}



