package com.lambdaschool.javazoo.service;

import com.lambdaschool.javazoo.model.Zoo;

import java.util.ArrayList;

public interface ZooService
{
	ArrayList<Zoo> findAll();

	Zoo findZooByname(String name);

	void delete(long id);

	void deleteAnimal(long zooid, long animalid);

	Zoo update(Zoo zoo, long id);

	Zoo save(Zoo zoo);
}
