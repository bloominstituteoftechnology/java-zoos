package com.lambdaschool.javazoos.controllers;

import com.lambdaschool.javazoos.services.AnimalServices;
import com.lambdaschool.javazoos.views.AnimalCounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnimalController
{
    @Autowired
    private AnimalServices animalServices;

    // http://localhost:2019/animals/count
    @GetMapping(value = "/animals/count", produces = "application/json")
    public ResponseEntity<?> findAnimalCounts()
    {
        List<AnimalCounts> rtnList = animalServices.findAnimalCounts();
        return new ResponseEntity<>(rtnList, HttpStatus.OK);
    }
}
