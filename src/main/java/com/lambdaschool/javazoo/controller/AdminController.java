package com.lambdaschool.javazoo.controller;

import com.lambdaschool.javazoo.model.Zoo;
import com.lambdaschool.javazoo.service.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping(value = "/admin")
public class AdminController
{
	@Autowired
	private ZooService zooService;

	//localhost:2019/admin/zoos/{id}
	@PutMapping(value = "/zoos/{zooid}")
	public ResponseEntity<?> updateZoo(
			@RequestBody Zoo updateZoo,
			@PathVariable long zooid
			)
	{
		zooService.update(updateZoo, zooid);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	//localhost:2019/admin/zoos
	@PostMapping(value = "/zoos",
				 consumes = {"application/json"},
				 produces = {"application/json"})
	public ResponseEntity<?> addNewZoo(@Valid
									   @RequestBody Zoo newZoo) throws URISyntaxException
	{
		newZoo = zooService.save(newZoo);
		HttpHeaders responseHeaders= new HttpHeaders();
		URI newZooURI = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{zooid}").
				buildAndExpand(newZoo.getZooid()).toUri();
		responseHeaders.setLocation(newZooURI);

		return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
	}

	//localhost:2019/admin/zoos/{id}
	@DeleteMapping(value = "/zoos/{zooid}")
	public ResponseEntity<?> deleteRestaurantById(@PathVariable long zooid)
	{
		zooService.delete(zooid);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	//localhost:2019/admin/zoos/{zooid}/animals/{animalid}
	@DeleteMapping(value = "/zoos/{zooid}/animals/{animalid}")
	public ResponseEntity<?> deleteAnimalInZoo(@PathVariable long zooid, @PathVariable long animalid)
	{
		zooService.deleteAnimal(zooid, animalid);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
