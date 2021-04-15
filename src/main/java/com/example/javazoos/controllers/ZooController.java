package com.example.javazoos.controllers;

import com.example.javazoos.services.ZooService;
import org.springframework.beans.factory.annotation.Autowired;

public class ZooController
{
    @Autowired
    private ZooService zooService;
//    http://localhost:2019/zoos/zoos
//    http://localhost:2019/zoos/zoo/5
}
