package com.lambdaschool.zoos.controllers;

import com.lambdaschool.zoos.models.Zoo;
import com.lambdaschool.zoos.services.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ZooController {

    @Autowired
    private ZooService zooService;

    @GetMapping(value = "/zoos",produces = "application/json")
    public ResponseEntity<?> listAllZoos() {
        List<Zoo> myZoos = zooService.findAllZoos();
        return new ResponseEntity<>(myZoos, HttpStatus.OK);
    }

    @GetMapping(value = "zoos/zoo/{zooid}",produces = "application/json")
    public ResponseEntity<?> getZooById(@PathVariable long zooid){
        Zoo z = zooService.findZooById(zooid);
        return new ResponseEntity<>(z,HttpStatus.OK);
    }

}
