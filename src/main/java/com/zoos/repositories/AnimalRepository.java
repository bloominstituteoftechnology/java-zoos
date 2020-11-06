package com.zoos.repositories;

import com.zoos.models.Animal;
import com.zoos.views.CountAnimalInZoo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

/**
 * The CRUD repository connecting Animals to the rest of the application
 */
public interface AnimalRepository extends CrudRepository<Animal, Long>
{
    /**
     * Custom query finding the animal and the number of zoos where they are located
     *
     * @return List (element type is CountAnimalInZoo) containing animal id, animal type, and
     * the count of zoos where the animal is located ordered by animal type
     */
    @Query(value = "SELECT a.animalid, a.animaltype, count(z.zooid) as countzoos FROM zooanimals z RIGHT JOIN animals a ON z.animalid=a.animalid GROUP BY a.animalid, a.animaltype ORDER BY a.animaltype",
        nativeQuery = true)
    ArrayList<CountAnimalInZoo> getCountAnimalInZoo();
}
