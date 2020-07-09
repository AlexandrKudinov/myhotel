package com.example.myHotel.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "room_type")
@Data
public class RoomType {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roomTypeSeq")
    @SequenceGenerator(
            name = "roomTypeSeq",
            sequenceName = "room_type_seq",
            initialValue = 6,
            allocationSize = 1)
    private short id;

    @Column(name = "name")
    private String name;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "roomType",
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
                    CascadeType.DETACH,
                    CascadeType.REFRESH})
    @JsonBackReference(value = "room - room_type")
    private List<Room> rooms;
}
