package com.lambdaschool.zoos.controllers;

import com.lambdaschool.zoos.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/animals")
public class AnimalController
{
    @Autowired
    private AnimalService animalService;

    @GetMapping(value = "/count",
        produces = {"application/json"})
    public ResponseEntity<?> getNumZoosAnimalsIn()
    {
        return new ResponseEntity<>(animalService.getCountAnimalInZoo(),
            HttpStatus.OK);
    }
}