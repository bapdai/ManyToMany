package com.example.manytomany.restapi;

import com.example.manytomany.entity.Rooms;
import com.example.manytomany.service.RoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rooms")
public class RoomsApi {
    // CURD
    @Autowired
    RoomsService roomsService;
    //
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Rooms>> getList(){
        return ResponseEntity.ok(roomsService.findAll());
    }
    //
    @RequestMapping(method = RequestMethod.GET, path = "{idRoom}")
    public ResponseEntity<?> getDetail(@PathVariable Integer idRoom) {
        Optional<Rooms> optionalRooms = roomsService.findById(idRoom);
        if (!optionalRooms.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(optionalRooms.get());
    }
    //
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Rooms> create(@RequestBody Rooms rooms) {
        return ResponseEntity.ok(roomsService.save(rooms));
    }

    //    Sua thong tin(U)
    @RequestMapping(method = RequestMethod.PUT, path = "{idRoom}")
    public ResponseEntity<Rooms> update(@PathVariable Integer idRoom, @RequestBody Rooms rooms) {
        Optional<Rooms> optionalRoom = roomsService.findById(idRoom);
        if (!optionalRoom.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        Rooms exitsRoom = optionalRoom.get();
        //     map object
        exitsRoom.setRankRoom(rooms.getRankRoom());
        exitsRoom.setPriceRoom(rooms.getPriceRoom());
        return ResponseEntity.ok(roomsService.save(exitsRoom));
    }
    //        Xoa thong tin
    @RequestMapping(method = RequestMethod.DELETE, path = "{idRoom}")
    public ResponseEntity<?> delete(@PathVariable Integer idRoom) {
        if (!roomsService.findById(idRoom).isPresent()) {
            ResponseEntity.badRequest().build();
        }
        roomsService.deleteById(idRoom);
        return ResponseEntity.ok().build();
    }
}
