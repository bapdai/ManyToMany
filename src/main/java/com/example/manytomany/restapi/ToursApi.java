package com.example.manytomany.restapi;

import com.example.manytomany.entity.Tours;
import com.example.manytomany.service.ToursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tours")
public class ToursApi {
    @Autowired
    ToursService toursService;

    //
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Tours>> getList() {
        return ResponseEntity.ok(toursService.findAll());
    }

    //
    @RequestMapping(method = RequestMethod.GET, path = "{idTour}")
    public ResponseEntity<?> getDetail(@PathVariable Integer idTour) {
        Optional<Tours> optionalTour = toursService.findById(idTour);
        if (!optionalTour.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(optionalTour.get());
    }

    //
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Tours> create(@RequestBody Tours tours) {
        return ResponseEntity.ok(toursService.save(tours));
    }

    //    Sua thong tin(U)
    @RequestMapping(method = RequestMethod.PUT, path = "{idTour}")
    public ResponseEntity<Tours> update(@PathVariable Integer idTour, @RequestBody Tours tours) {
        Optional<Tours> optionalTour = toursService.findById(idTour);
        if (!optionalTour.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        Tours exitsTour = optionalTour.get();
        //     map object
        exitsTour.setNameTour(tours.getNameTour());
        exitsTour.setClients(tours.getClients());
        exitsTour.setHotels(tours.getHotels());
        return ResponseEntity.ok(toursService.save(exitsTour));
    }

    //        Xoa thong tin
    @RequestMapping(method = RequestMethod.DELETE, path = "{idTour}")
    public ResponseEntity<?> delete(@PathVariable Integer idTour) {
        if (!toursService.findById(idTour).isPresent()) {
            ResponseEntity.badRequest().build();
        }
        toursService.deleteById(idTour);
        return ResponseEntity.ok().build();
    }
}
