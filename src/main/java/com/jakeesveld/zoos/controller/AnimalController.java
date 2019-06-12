package com.jakeesveld.zoos.controller;

import com.jakeesveld.zoos.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping(value = "/animals/count", produces = {"application/json"})
    public ResponseEntity<?> getAnimalsCount(){
        return new ResponseEntity<>(animalService.getAnimalCount(), HttpStatus.OK);
    }
}
