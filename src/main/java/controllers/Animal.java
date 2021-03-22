package controllers;

import models.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.AnimalServices;

import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalServices animalServices;

    @GetMapping(value = "/count",produces = "application/json")
    public ResponseEntity<?> listAllAnimals()
    {
        return
        new ResponseEntity<>(animalServices.getAnimalCountInZoo(), HttpStatus.OK);
    }



}
