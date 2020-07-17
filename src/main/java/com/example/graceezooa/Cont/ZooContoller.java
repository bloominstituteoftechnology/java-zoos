package com.example.graceezooa.Cont;

import com.example.graceezooa.Models.Zoo;
import com.example.graceezooa.Services.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/zoos")
public class ZooContoller
{

    @Autowired
    private ZooService zooService;

    //http://localhost:2019/zoos/zoos
    @GetMapping(value = "/zoos", produces = {"application/json"})
    public ResponseEntity<?> listallZoos()
    {
        ArrayList<Zoo> zooList = zooService.findall();
        return new ResponseEntity<>(zooList, HttpStatus.OK);

    }


    //http://localhost:2019/zoos/zoo/5
    @GetMapping(value = "/zoo/{id}", produces = {"application/json"})
    public ResponseEntity<?> findbyid(@PathVariable long id)
    {
        Zoo z = zooService.findbyid(id);
        return new ResponseEntity<>(z,
                HttpStatus.OK);

    }


}
