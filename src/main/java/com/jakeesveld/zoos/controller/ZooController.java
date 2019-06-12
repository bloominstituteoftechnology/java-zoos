package com.jakeesveld.zoos.controller;

import com.jakeesveld.zoos.service.AnimalService;
import com.jakeesveld.zoos.service.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZooController {

    @Autowired
    private ZooService zooService;

    @GetMapping(value = "/zoos/zoos", produces = {"application/json"})
    public ResponseEntity<?> getZooDetails(){
        return new ResponseEntity<>(zooService.getZooDetails(), HttpStatus.OK);
    }
}
