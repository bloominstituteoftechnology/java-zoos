package com.lambdaschool.zoo.controllers;

import com.lambdaschool.zoo.models.Zoo;
import com.lambdaschool.zoo.services.ZooServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping(value = "/zoos")
public class ZooController {
    @Autowired
    private ZooServices zooServices;

    @GetMapping(value = "/zoos", produces = "application/json")
    public ResponseEntity<?> findAllZoos(){
        return new ResponseEntity<>(zooServices.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/zoo/{id}", produces = "application/json")
    public ResponseEntity<?> findZooById(@PathVariable long id) throws Throwable {
        Zoo zoo = zooServices.findZooById(id);
        return new ResponseEntity<>(zoo, HttpStatus.OK);
    }

    @PostMapping(value = "/zoo", produces = "application/json", consumes = "application/json")
    public ResponseEntity<?> addZoo(@Valid @RequestBody Zoo newZoo) throws URISyntaxException{
        newZoo.setZooid(0);
        newZoo = zooServices.save(newZoo);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newZooURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{zooid}")
                .buildAndExpand(newZoo.getZooid())
                .toUri();
        responseHeaders.setLocation(newZooURI);

        return new ResponseEntity<>(newZoo, responseHeaders, HttpStatus.CREATED);
    }

    @PutMapping(value = "/zoo/{id}", consumes = "application/json")
    public  ResponseEntity<?> updateZoo(@RequestBody Zoo updatedZoo, @PathVariable long id){
        updatedZoo.setZooid(id);
        zooServices.save(updatedZoo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping(value = "/zoo/{id}", consumes = "application/json")
    public ResponseEntity<?> patchZoo(@RequestBody Zoo patchedZoo, @PathVariable long id){
        patchedZoo.setZooid(id);
        zooServices.update(patchedZoo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/zoo/{id}")
    public ResponseEntity<?> deleteZoo(@PathVariable long id){
        zooServices.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
