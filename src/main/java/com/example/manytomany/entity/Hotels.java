package com.example.manytomany.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "hotels")
public class Hotels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idHotel")
    private Integer idHotel;

    @Column(name = "nameHotel")
    private String nameHotel;

    @Column(name = "room")
    private Integer room;

    @OneToMany(mappedBy = "hotels")
    Set<Tours> Tours;

    @ManyToOne
    @JoinColumn(name = "rooms_idRoom")
    Hotels hotels;
}
