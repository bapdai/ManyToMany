package com.example.manytomany.restapi;

import com.example.manytomany.entity.Hotels;
import com.example.manytomany.service.HotelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hotels")
public class HotelsApi {
    @Autowired
    HotelsService hotelsService;
    //
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Hotels>> getList(){
        return ResponseEntity.ok(hotelsService.findAll());
    }
    //
    @RequestMapping(method = RequestMethod.GET, path = "{idHotel}")
    public ResponseEntity<?> getDetail(@PathVariable Integer idHotel) {
        Optional<Hotels> optionalHotel = hotelsService.findById(idHotel);
        if (!optionalHotel.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(optionalHotel.get());
    }
    //
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Hotels> create(@RequestBody Hotels hotels) {
        return ResponseEntity.ok(hotelsService.save(hotels));
    }

    //    Sua thong tin(U)
    @RequestMapping(method = RequestMethod.PUT, path = "{idHotel}")
    public ResponseEntity<Hotels> update(@PathVariable Integer idHotel, @RequestBody Hotels hotels) {
        Optional<Hotels> optionalHotel = hotelsService.findById(idHotel);
        if (!optionalHotel.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        Hotels exitsHotel = optionalHotel.get();
        //     map object
        exitsHotel.setNameHotel(hotels.getNameHotel());
        exitsHotel.setRoom(hotels.getRoom());
        return ResponseEntity.ok(hotelsService.save(exitsHotel));
    }
    //        Xoa thong tin
    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (!hotelsService.findById(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }
        hotelsService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
