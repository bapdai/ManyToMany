package com.example.manytomany.service;

import com.example.manytomany.entity.Tours;
import com.example.manytomany.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToursService {
    @Autowired
    private TourRepository tourRepository;

    public List<Tours> findAll() {
        return tourRepository.findAll();
    }

    public Optional<Tours> findById(Integer idTour){
        return tourRepository.findById(idTour);
    }

    public Tours save(Tours tours){
        return tourRepository.save(tours);
    }

    public void deleteById(Integer idTour) {
        tourRepository.deleteById(idTour);
    }
}
