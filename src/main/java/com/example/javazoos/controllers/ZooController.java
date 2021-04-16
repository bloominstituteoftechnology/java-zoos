package com.example.javazoos.controllers;

import com.example.javazoos.models.Zoo;
import com.example.javazoos.services.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/zoos")
public class ZooController
{
    @Autowired
    private ZooService zooService;

//    http://localhost:2019/zoos/zoos
    @GetMapping(value = "/zoos", produces = "application/json")
    public ResponseEntity<?> findAllZoos()
    {
        List<Zoo> rtnList = zooService.findAll();
        return new ResponseEntity<>(rtnList, HttpStatus.OK);
    }

//    http://localhost:2019/zoos/zoo/5
    @GetMapping(value = "/zoo/{zooid}", produces = "application/json")
    public ResponseEntity<?> findByZooId(@PathVariable long zooid)
    {
        Zoo z = zooService.findByZooId(zooid);
        return new ResponseEntity<>(z, HttpStatus.OK);
    }

}
