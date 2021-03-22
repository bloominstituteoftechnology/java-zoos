package controllers;

import models.Zoo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.ZooServices;

import java.util.List;

@RestController
@RequestMapping("/zoos")
public class ZooController
{

    @Autowired
    private ZooServices zooService;


    @GetMapping(value = "/zoos", produces = "application/json")
    public ResponseEntity<?> listAllZoos()
    {
        List<Zoo> myZoos = zooService.findAll();
        return new ResponseEntity<>(myZoos, HttpStatus.OK);
    }




    @GetMapping(value = "/zoo/{zooId}", produces = "application/json")
    public ResponseEntity<?> getZooById(@PathVariable Long zooId)
    {
        Zoo zoo = zooService.findZooById(zooId);
        return new ResponseEntity<>(zoo, HttpStatus.OK);
    }

}