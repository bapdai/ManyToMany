package com.example.manytomany.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tours")
public class Tours{
    @Id
    @Column(name = "idTour")
    private Integer idTour;

    @Column(name = "nameTour")
    private Integer nameTour;

    @ManyToOne
    @JoinColumn(name = "clients_idClient")
    Clients clients;

    @ManyToOne
    @JoinColumn(name = "hotels_idHotel")
    Hotels hotels;
}
