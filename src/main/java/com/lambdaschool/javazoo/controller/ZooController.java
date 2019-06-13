package com.lambdaschool.javazoo.controller;

import com.lambdaschool.javazoo.service.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/home")
public class ZooController
{
	@Autowired
	private ZooService zooService;

	//localhost:2019/home/zoos/all
	@GetMapping(value = "/zoos/all", produces = {"application/json"})
	public ResponseEntity<?> listAllZoos()
	{
		return new ResponseEntity<>(zooService.findAll(), HttpStatus.OK);
	}

	//localhost:2019/home/zoos/{zooname}
	@GetMapping(value = "/zoos/{zooName}", produces = {"application/json"})
	public ResponseEntity<?> getZooByName(@PathVariable String zooName)
	{
		return new ResponseEntity<>(zooService.findZooByname(zooName), HttpStatus.OK);
	}



}
