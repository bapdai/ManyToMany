package com.example.manytomany.service;

import com.example.manytomany.entity.Hotels;
import com.example.manytomany.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelsService {
    @Autowired
    private HotelRepository hotelRepository;

    public List<Hotels> findAll() {
        return hotelRepository.findAll();
    }

    public Optional<Hotels> findById(Integer idHotel){
        return hotelRepository.findById(idHotel);
    }

    public Hotels save(Hotels hotels){
        return hotelRepository.save(hotels);
    }

    public void deleteById(Integer idHotel) {
        hotelRepository.deleteById(idHotel);
    }
}
