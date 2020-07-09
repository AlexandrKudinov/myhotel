package com.example.myHotel.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "person")
@Data
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "personSeq")
    @SequenceGenerator(
            name = "personSeq",
            sequenceName = "person_seq",
            initialValue = 10,
            allocationSize = 1)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "admin")
    private boolean admin;

    @Column(name = "blocked")
    private boolean blocked;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "person",
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
                    CascadeType.DETACH,
                    CascadeType.REFRESH})
    @JsonBackReference(value = "person - reservations")
    private List<Reservation> reservations;

}
