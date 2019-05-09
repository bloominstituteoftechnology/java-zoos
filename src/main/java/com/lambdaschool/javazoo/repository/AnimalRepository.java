package com.lambdaschool.javazoo.repository;

import com.lambdaschool.javazoo.model.Animal;
import com.lambdaschool.javazoo.view.CountZoosWithAnimals;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface AnimalRepository extends CrudRepository<Animal, Long>
{
	Animal findByAnimaltype(String name);

	@Query(value = "SELECT za.animalid, animaltype, count(zooid) as countzoos FROM zooanimal za INNER JOIN  animal a " +
			"on za.animalid=a.animalid GROUP BY za.animalid, animaltype",
		   nativeQuery = true)
	ArrayList<CountZoosWithAnimals> getCountZoosWithAnimals();
}
