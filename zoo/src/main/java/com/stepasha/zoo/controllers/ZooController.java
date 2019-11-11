package com.stepasha.zoo.controllers;

import com.stepasha.zoo.models.Zoo;
import com.stepasha.zoo.services.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/zoos")
public class ZooController
{
    @Autowired
    private ZooService zooService;
   // http://localhost:2020/zoos/zoos
    @GetMapping(value = "/zoos", produces = {"application/json"})
    public ResponseEntity<?> listAllZoos()
    {
        return new ResponseEntity<>(zooService.findAllZoos(), HttpStatus.OK);
    }
    // http://localhost:2020/zoos/zoos/1
    @GetMapping(value = "/zoos/{id}", produces = {"application/json"})
    public ResponseEntity<?> findZooById(@PathVariable long id)
    {
        Zoo z = zooService.findZooById(id);
        return new ResponseEntity<>(z, HttpStatus.OK);
    }

    // http://localhost:2020/zoos/zoos/name
    @GetMapping(value = "/{name}", produces = {"application/json"})
    public ResponseEntity<?> findZooByName(@PathVariable String name)
    {
        Zoo z = zooService.findZooByName(name);
        return new ResponseEntity<>(z, HttpStatus.OK);
    }
}
