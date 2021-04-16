package com.lambdaschool.zoos.controllers;

import com.lambdaschool.zoos.models.Zoo;
import com.lambdaschool.zoos.services.ZooServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
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
  @GetMapping(value = "/zoo/{zooid}", produces = "application/json")
  public ResponseEntity<?> getZooById(@PathVariable Long zooid) {
    Zoo z = zooServices.findZooById(zooid);
    return new ResponseEntity<>(z, HttpStatus.OK);
  }

//  POST http://localhost:2019/zoos/zoo
  @PostMapping(value = "/zoo", consumes = "application/json",
      produces = "application/json")
  public ResponseEntity<?> addNewZoo(@Valid @RequestBody Zoo newZoo)
      throws URISyntaxException{
    newZoo.setZooid(0);
    newZoo = zooServices.save(newZoo);

    HttpHeaders responseHeaders = new HttpHeaders();
    URI newUserURI = ServletUriComponentsBuilder.fromCurrentRequest()
                                                .path("/{zoodid}")
                                                .buildAndExpand(newZoo.getZooid())
                                                .toUri();
    responseHeaders.setLocation(newUserURI);

    return new ResponseEntity<>(newZoo, responseHeaders, HttpStatus.CREATED);
  }

//  PUT http://localhost:2019/zoos/zoo/5
  @PutMapping(value = "/zoo/{zooid}", consumes = "application/json",
      produces = "application/json")
  public ResponseEntity<?> updateFullZoo(@Valid @RequestBody Zoo updateZoo,
                                         @PathVariable long zooid) {
    updateZoo.setZooid(zooid);
    zooServices.save(updateZoo);

    return new ResponseEntity<>(updateZoo, HttpStatus.OK);
  }

//  PATCH http://localhost:2019/zoos/zoo/4
  @PatchMapping(value = "/zoo/{zooid}", consumes = "application/json",
      produces = "application/json")
  public ResponseEntity<?> updateZoo(
      @RequestBody Zoo updateZoo, @PathVariable long zooid) {
    zooServices.update(updateZoo, zooid);
    return new ResponseEntity<>(updateZoo, HttpStatus.OK);
  }
//  DELETE http://localhost:2019/zoos/zoo/5
}
