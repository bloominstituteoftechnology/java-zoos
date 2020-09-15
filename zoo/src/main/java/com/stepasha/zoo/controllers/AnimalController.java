package com.stepasha.zoo.controllers;

import com.stepasha.zoo.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/animals")
public class AnimalController {
    @Autowired
    private AnimalService animalService;

    // http://localhost:2020/animals/count
    @GetMapping(value = "/count", produces = "application/json")
    private ResponseEntity<?> getCountOfAnimalPresenceAtZoos(){
        return new ResponseEntity<>(animalService.getCountOfAnimalPresenceAtZoos(), HttpStatus.OK);
    }
}
