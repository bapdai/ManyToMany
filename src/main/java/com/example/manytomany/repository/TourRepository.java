package com.example.manytomany.repository;

import com.example.manytomany.entity.Tours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourRepository extends JpaRepository<Tours, Integer> {
}
