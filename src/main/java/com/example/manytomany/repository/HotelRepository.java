package com.example.manytomany.repository;

import com.example.manytomany.entity.Hotels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotels, Integer> {
}
