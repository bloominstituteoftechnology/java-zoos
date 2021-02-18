package com.lambda.zoo.repository;

import com.lambda.zoo.models.Animal;
import com.lambda.zoo.views.CountAnimalZoo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface AnimalRepository extends CrudRepository<Animal, Long> {

    @Query(value = "SELECT a.animalid, a.animaltype, count(z.zooid) as countzoos FROM zooanimals z RIGHT JOIN animals a ON z.animalid=a.animalid GROUP BY a.animalid, a.animaltype ORDER BY a.animaltype",
            nativeQuery = true)
    ArrayList<CountAnimalZoo> getCountAnimalInZoo();

}
