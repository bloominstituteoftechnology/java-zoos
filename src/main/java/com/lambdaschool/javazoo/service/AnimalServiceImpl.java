package com.lambdaschool.javazoo.service;

import com.lambdaschool.javazoo.model.Animal;
import com.lambdaschool.javazoo.repository.AnimalRepository;
import com.lambdaschool.javazoo.view.CountZoosWithAnimals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;

@Service(value = "animalService")
public class AnimalServiceImpl implements AnimalService
{
	@Autowired
	private AnimalRepository animalrepos;

	@Override
	public ArrayList<Animal> findAll()
	{
		ArrayList<Animal> list = new ArrayList<>();
		animalrepos.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public Animal findAnimalByName(String name) throws EntityNotFoundException
	{
		Animal animal = animalrepos.findByAnimaltype(name);

		if (animal == null)
		{
			throw new EntityNotFoundException("Animal " + name + " not found");
		}

		return animal;
	}

	@Override
	public ArrayList<CountZoosWithAnimals> getCountZoosWithAnimals()
	{
		return animalrepos.getCountZoosWithAnimals();
	}
}
