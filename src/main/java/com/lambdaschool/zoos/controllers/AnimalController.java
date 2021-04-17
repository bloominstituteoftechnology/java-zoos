package com.lambdaschool.zoos.controllers;


import com.lambdaschool.zoos.services.AnimalService;
import com.lambdaschool.zoos.views.AnimalCounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping(value = "/count",
            produces = "application/json")
    public ResponseEntity<?> findAllAnimals()
    {
        List<AnimalCounts> myList = animalService.getAnimalCounts();
        return new ResponseEntity<>(myList,
                HttpStatus.OK);
    }




}
