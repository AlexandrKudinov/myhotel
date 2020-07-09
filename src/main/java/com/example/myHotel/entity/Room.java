package com.example.myHotel.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "room")
@Data
public class Room {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roomSeq")
    @SequenceGenerator(
            name = "roomSeq",
            sequenceName = "room_seq",
            initialValue = 46,
            allocationSize = 1)
    private long id;

    @Column(name = "number")
    private int number;

    @Column(name = "price")
    private int price;

    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH})
    @JoinColumn(name = "hotel_id")
    @JsonManagedReference(value = "hotel - room")
    private Hotel hotel;

    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH})
    @JoinColumn(name = "room_type_id")
    @JsonManagedReference(value = "room - room_type")
    private RoomType roomType;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "room",
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
                    CascadeType.DETACH,
                    CascadeType.REFRESH})
    @JsonBackReference(value = "room - reservation")
    private List<Reservation> reservations;
}