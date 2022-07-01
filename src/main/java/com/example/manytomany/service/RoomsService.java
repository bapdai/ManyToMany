package com.example.manytomany.service;

import com.example.manytomany.entity.Rooms;
import com.example.manytomany.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomsService {
    @Autowired
    private RoomRepository roomRepository;

    public List<Rooms> findAll() {
        return roomRepository.findAll();
    }

    public Optional<Rooms> findById(Integer idRoom){
        return roomRepository.findById(idRoom);
    }

    public Rooms save(Rooms rooms){
        return roomRepository.save(rooms);
    }

    public void deleteById(Integer idRoom) {
        roomRepository.deleteById(idRoom);
    }
}
