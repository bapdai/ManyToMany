package com.example.manytomany.restapi;

import com.example.manytomany.entity.Clients;
import com.example.manytomany.service.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clients")
public class ClientsApi {
    @Autowired
    ClientsService clientsService;
    //
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Clients>> getList(){
        return ResponseEntity.ok(clientsService.findAll());
    }
    //
    @RequestMapping(method = RequestMethod.GET, path = "{idClient}")
    public ResponseEntity<?> getDetail(@PathVariable Integer idClient) {
        Optional<Clients> optionalClient = clientsService.findById(idClient);
        if (!optionalClient.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(optionalClient.get());
    }
    //
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Clients> create(@RequestBody Clients clients) {
        return ResponseEntity.ok(clientsService.save(clients));
    }

    //    Sua thong tin(U)
    @RequestMapping(method = RequestMethod.PUT, path = "{idClient}")
    public ResponseEntity<Clients> update(@PathVariable Integer idClient, @RequestBody Clients clients) {
        Optional<Clients> optionalClient = clientsService.findById(idClient);
        if (!optionalClient.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        Clients exitsClient = optionalClient.get();
        //     map object
        exitsClient.setNameClient(clients.getNameClient());
        exitsClient.setAgeClient(clients.getAgeClient());
        exitsClient.setPhoneClient(clients.getPhoneClient());
        return ResponseEntity.ok(clientsService.save(exitsClient));
    }
    //        Xoa thong tin
    @RequestMapping(method = RequestMethod.DELETE, path = "{idClient}")
    public ResponseEntity<?> delete(@PathVariable Integer idClient) {
        if (!clientsService.findById(idClient).isPresent()) {
            ResponseEntity.badRequest().build();
        }
        clientsService.deleteById(idClient);
        return ResponseEntity.ok().build();
    }
}
