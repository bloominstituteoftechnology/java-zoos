package local.tylerb.zoo.controllers;

import local.tylerb.zoo.model.Zoo;
import local.tylerb.zoo.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/zoos")
public class ZooController {

    @Autowired
    Service service;

    @GetMapping(value = "/zoos")
    public ResponseEntity<?> getAll(){
        List<Zoo> list = service.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/zoo/{id}")
    public ResponseEntity<?> getZooById(@PathVariable long id) {
        Zoo zoo = service.getZooById(id);
        return new ResponseEntity<>(zoo, HttpStatus.OK);
    }

    @GetMapping(value = "/zoo/namelike/{name}")
    public ResponseEntity<?> getStringByName(@PathVariable String name) {
        List<Zoo> zoo = service.getZooByLikeName(name);
        return new ResponseEntity<>(zoo, HttpStatus.OK);
    }

    @PostMapping(value = "/zoo")
    public ResponseEntity<?> addZoo(@RequestBody Zoo zoo) {
        zoo = service.addZoo(zoo);
        HttpHeaders responseHeaders = new HttpHeaders();
        URI zooURI = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(zoo.getZooid())
                .toUri();
        responseHeaders.setLocation(zooURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @PutMapping(value = "/zoo/{id}")
    public ResponseEntity<?> updateZoo(@PathVariable long id, @RequestBody Zoo zoo) {
        service.updateZoo(id, zoo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/zoo/{id}")
    public ResponseEntity<?> deleteZoo(@PathVariable long id) {
        service.deleteZoo(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/zoo/{zooid}/animals/{animalid}")
    public ResponseEntity<?> deleteZooAnimals(@PathVariable long zooid, @PathVariable long animalid) {
        service.deleteZooAnimalsItem(zooid, animalid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/zoo/{zooid}/animals/{animalid}")
    public ResponseEntity<?> addZooAnimals(@PathVariable long zooid, @PathVariable long animalid) {
        service.addZooAnimal(zooid, animalid);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
