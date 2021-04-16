package com.example.javazoos.controllers;

import com.example.javazoos.models.Animal;
import com.example.javazoos.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController
{
    @Autowired
    private AnimalService animalService;

//    http://localhost:2019/animals/count
    @RequestMapping(value = "/count", produces = "application/json")
    public ResponseEntity<?> listAllAnimalCounts()
    {
        List<Animal> rtnList = animalService.FindAllAnimalsAndCounts();
        return new ResponseEntity<>(rtnList, HttpStatus.OK);
    }

}
