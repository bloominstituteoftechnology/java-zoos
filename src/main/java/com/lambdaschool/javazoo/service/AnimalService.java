package com.lambdaschool.javazoo.service;

import com.lambdaschool.javazoo.model.Animal;
import com.lambdaschool.javazoo.view.CountZoosWithAnimals;

import java.util.ArrayList;

public interface AnimalService
{
	ArrayList<Animal> findAll();

	Animal findAnimalByName(String name);

	ArrayList<CountZoosWithAnimals> getCountZoosWithAnimals();
}
