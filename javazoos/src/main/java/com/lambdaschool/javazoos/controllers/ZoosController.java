package com.lambdaschool.javazoos.controllers;

import com.lambdaschool.javazoos.models.Zoo;
import com.lambdaschool.javazoos.services.ZooServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/zoos")
public class ZoosController
{
    @Autowired
    private ZooServices zooServices;

    //    http://localhost:2019/zoos/zoos
    @GetMapping(value = "/zoos", produces = "application/json")
    public ResponseEntity<?> findAllZoos()
    {
        List<Zoo> rtnList = zooServices.findAllZoos();
        return new ResponseEntity<>(rtnList, HttpStatus.OK);
    }

    //    http://localhost:2019/zoos/zoo/5
    @GetMapping(value = "/zoo/{zooid}", produces = "application/json")
    public ResponseEntity<?> getZooById(@PathVariable long zooid)
    {
        Zoo z = zooServices.findZooById(zooid);
        return new ResponseEntity<>(z, HttpStatus.OK);
    }

    //    Stretch Goals
    //    POST http://localhost:2019/zoos/zoo
    @PostMapping(value = "/zoo", consumes = "application/json")
    public ResponseEntity<?> addNewZoo(@Valid @RequestBody Zoo newZoo)
    {
        newZoo.setZooid(0);
        newZoo = zooServices.save(newZoo);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newUserURI = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{zooid}")
            .buildAndExpand(newZoo.getZooid())
            .toUri();
        responseHeaders.setLocation(newUserURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    //    PUT http://localhost:2019/zoos/zoo/5
    @PutMapping(value = "/zoo/{zooid}", consumes = "application/json")
    public ResponseEntity<?> updateFullZoo(@Valid @RequestBody Zoo updateZoo, @PathVariable long zooid)
    {
        updateZoo.setZooid(zooid);
        zooServices.save(updateZoo);

        return new ResponseEntity<>(HttpStatus.OK);
    }



    //    PATCH http://localhost:2019/zoos/zoo/4
    //    DELETE http://localhost:2019/zoos/zoo/5
}
