package com.jakeesveld.zoos.controller;

import com.jakeesveld.zoos.model.Zoo;
import com.jakeesveld.zoos.service.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ZooController {

    @Autowired
    private ZooService zooService;

    @GetMapping(value = "/zoos/zoos", produces = {"application/json"})
    public ResponseEntity<?> getZooDetails() {
        return new ResponseEntity<>(zooService.getZooDetails(), HttpStatus.OK);
    }

    @GetMapping(value = "/zoos/zoos/all", produces = {"application/json"})
    public ResponseEntity<?> getAllZoos(){
        return new ResponseEntity<>(zooService.findAll(), HttpStatus.OK);
    }

    @PutMapping(value = "/admin/zoos/{id}")
    public ResponseEntity<?> updateZoo(@PathVariable long id, @RequestBody Zoo updatedZoo) {
        zooService.updateZoo(id, updatedZoo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/admin/zoos")
    public ResponseEntity<?> addZoo(@RequestBody Zoo zoo) {
        zooService.addZoo(zoo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/admin/zoos/{id}")
    public ResponseEntity<?> deleteZoo(@PathVariable long id){
        zooService.deleteZoo(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
