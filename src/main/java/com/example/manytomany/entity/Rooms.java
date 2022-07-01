package com.example.manytomany.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.EntityGraph;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "rooms")
public class Rooms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRoom")
    private Integer idRoom;

    @Column(name = "rankRoom")
    private String rankRoom;

    @Column(name = "priceRoom")
    private Double priceRoom;

    @OneToMany(mappedBy = "rooms")
    Set<Hotels> hotels;
}
