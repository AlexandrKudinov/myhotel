package com.example.myHotel.service;

import com.example.myHotel.entity.Person;

import java.util.List;

public interface PersonService {
    List<Person> findAll();

    Person findById(long id);

    long save(Person person);

    long deleteById(long id);

    long addToBlackList(long id);
}
