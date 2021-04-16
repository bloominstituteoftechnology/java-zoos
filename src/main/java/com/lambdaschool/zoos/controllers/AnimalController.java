package com.lambdaschool.zoos.controllers;

import com.lambdaschool.zoos.services.AnimalServices;
import com.lambdaschool.zoos.views.AnimalCounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {

  @Autowired
  private AnimalServices animalServices;

  //http://localhost:2019/animals/count
  @GetMapping(value = "/count", produces = "application/json")
  public ResponseEntity<?> getAnimalCounts() {
    List<AnimalCounts> rtnList = animalServices.getAnimalCounts();
    return new ResponseEntity<>(rtnList, HttpStatus.OK);
  }

}
