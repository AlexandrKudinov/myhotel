package com.example.myHotel.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "hotel")
@Data
public class Hotel {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hotelSeq")
    @SequenceGenerator(
            name = "hotelSeq",
            sequenceName = "hotel_seq",
            initialValue = 10,
            allocationSize = 1)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "house_number")
    private int houseNumber;

    @Column(name = "stars")
    private byte stars;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "hotel",
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
                    CascadeType.DETACH,
                    CascadeType.REFRESH})
    @JsonBackReference(value = "hotel - room")
    private List<Room> rooms;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "hotel",
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
                    CascadeType.DETACH,
                    CascadeType.REFRESH})
    @JsonBackReference(value = "hotel - provides")
    private List<Provide> provides;

}