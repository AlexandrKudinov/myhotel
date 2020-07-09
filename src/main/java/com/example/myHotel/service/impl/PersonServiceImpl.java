package com.example.myHotel.service.impl;

import com.example.myHotel.dao.PersonRepository;
import com.example.myHotel.entity.Person;
import com.example.myHotel.exception.HotelServiceException;
import com.example.myHotel.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;

    private final String EXCEPTION_MESSAGE = "Person not found";

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person findById(long id) {
        return personRepository.findById(id).orElseThrow(() -> new HotelServiceException(EXCEPTION_MESSAGE));
    }

    @Override
    public long save(Person person) {
        return personRepository.save(person).getId();
    }

    @Override
    public long deleteById(long id) {
        if (personRepository.findById(id).isPresent()) {
            personRepository.deleteById(id);
            return id;
        } else {
            throw new HotelServiceException(EXCEPTION_MESSAGE);
        }
    }

    @Override
    public long addToBlackList(long id) {
        Person person = personRepository.findById(id).orElseThrow(() -> new HotelServiceException(EXCEPTION_MESSAGE));
        person.setBlocked(true);
        personRepository.save(person);
        return person.getId();
    }

}
