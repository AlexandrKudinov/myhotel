package com.example.myHotel.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "reservation")
@Data
public class Reservation {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reservationSeq")
    @SequenceGenerator(
            name = "reservationSeq",
            sequenceName = "reservation_seq",
            initialValue = 10,
            allocationSize = 1)
    private long id;

    @Column(name = "date_of_arrival")
    private LocalDate dateOfArrival;

    @Column(name = "date_of_departure")
    private LocalDate dateOfDeparture;

    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH})
    @JoinColumn(name = "room_id")
    @JsonManagedReference(value = "room - reservation")
    private Room room;

    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH})
    @JoinColumn(name = "person_id")
    @JsonManagedReference(value = "person - reservations")
    private Person person;

    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH})
    @JoinColumn(name = "provide_id")
    @JsonManagedReference(value = "provide - reservations")
    private Provide provide;

}
