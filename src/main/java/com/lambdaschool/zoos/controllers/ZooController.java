package com.lambdaschool.zoos.controllers;

import com.lambdaschool.zoos.models.Zoo;
import com.lambdaschool.zoos.services.ZooServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zoos")
public class ZooController {

  @Autowired
  private ZooServices zooServices;

//  http://localhost:2019/zoos/zoos
  @GetMapping(value = "/zoos", produces = "application/json")
  public ResponseEntity<?> listAllZoos(){

    List<Zoo> myZoos = zooServices.findAll();
    return new ResponseEntity<>(myZoos, HttpStatus.OK);
  }
  
//  http://localhost:2019/zoos/zoo/5
//  POST http://localhost:2019/zoos/zoo
//  PUT http://localhost:2019/zoos/zoo/5
//  PATCH http://localhost:2019/zoos/zoo/4
//  DELETE http://localhost:2019/zoos/zoo/5
}
