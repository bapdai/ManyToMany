package com.example.manytomany.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "clients")
public class Clients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idClient")
    private Integer idClient;

    @Column(name = "nameClient")
    private String nameClient;

    @Column(name = "ageClient")
    private Integer ageClient;

    @Column(name = "phoneClient")
    private String phoneClient;

    @OneToMany(mappedBy = "clients")
    Set<Tours> tours;
}
