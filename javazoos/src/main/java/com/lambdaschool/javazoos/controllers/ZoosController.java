package com.lambdaschool.javazoos.controllers;

import com.lambdaschool.javazoos.models.Zoo;
import com.lambdaschool.javazoos.services.ZooServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/zoos")
public class ZoosController
{
    @Autowired
    private ZooServices zooServices;

    //    http://localhost:2019/zoos/zoos
    @GetMapping(value = "/zoos", produces = "application/json")
    public ResponseEntity<?> findAllZoos()
    {
        List<Zoo> rtnList = zooServices.findAllZoos();
        return new ResponseEntity<>(rtnList, HttpStatus.OK);
    }

    //    http://localhost:2019/zoos/zoo/5
    @GetMapping(value = "/zoo/{zooid}", produces = "application/json")
    public ResponseEntity<?> getZooById(@PathVariable long zooid)
    {
        Zoo z = zooServices.findZooById(zooid);
        return new ResponseEntity<>(z, HttpStatus.OK);
    }

    //    Stretch Goals
    //    POST http://localhost:2019/zoos/zoo
    //    PUT http://localhost:2019/zoos/zoo/5
    //    PATCH http://localhost:2019/zoos/zoo/4
    //    DELETE http://localhost:2019/zoos/zoo/5
}
