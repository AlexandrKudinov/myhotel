package com.example.myHotel.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "provide")
@Data
public class Provide {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "provideSeq")
    @SequenceGenerator(
            name = "provideSeq",
            sequenceName = "provide_seq",
            initialValue = 11,
            allocationSize = 1)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private int price;

    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH})
    @JoinColumn(name = "hotel_id")
    @JsonManagedReference(value = "hotel - provides")
    private Hotel hotel;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "provide",
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
                    CascadeType.DETACH,
                    CascadeType.REFRESH})
    @JsonBackReference(value = "provide - reservations")
    private List<Reservation> reservations;

}
