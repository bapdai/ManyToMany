package com.example.manytomany.service;

import com.example.manytomany.entity.Clients;
import com.example.manytomany.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientsService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Clients> findAll() {
        return clientRepository.findAll();
    }

    public Optional<Clients> findById(Integer idClient){
        return clientRepository.findById(idClient);
    }

    public Clients save(Clients clients){
        return clientRepository.save(clients);
    }

    public void deleteById(Integer idClient) {
        clientRepository.deleteById(idClient);
    }
}
