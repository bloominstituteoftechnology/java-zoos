package com.lambdaschool.javazoo.controller;

import com.lambdaschool.javazoo.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/animals")
public class AnimalController
{
	@Autowired
	private AnimalService animalService;

	//localhost:2019/animals/all
	@GetMapping(value = "/all", produces = {"application/json"})
	public ResponseEntity<?> listAllAnimals()
	{
		return new ResponseEntity<>(animalService.findAll(), HttpStatus.OK);

	}

	//localhost:2019/animals/{name}
	@GetMapping(value = "/{name}", produces = {"application/json"})
	public ResponseEntity<?> getAnimalByName(@PathVariable String name)
	{
		return new ResponseEntity<>(animalService.findAnimalByName(name), HttpStatus.OK);
	}


	//localhost:2019/animals/count
	@GetMapping(value = "/count", produces = {"application/json"})
	public ResponseEntity<?> getCountZoosWithAnimals()
	{
		return new ResponseEntity<>(animalService.getCountZoosWithAnimals(), HttpStatus.OK);
	}
}
