package com.lambdaschool.zoo.repository;

import com.lambdaschool.zoo.models.Animal;
import com.lambdaschool.zoo.views.CountAnimalsInZoo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface AnimalRepository extends CrudRepository<Animal, Long> {

    @Query(value =
            "SELECT a.animalid, a.animaltype, count(z.zooid) as countzoos " +
            "FROM zooanimals z RIGHT JOIN animals a ON z.animalid=a.animalid " +
            "GROUP BY a.animalid, a.animaltype " +
            "ORDER BY a.animaltype", nativeQuery = true)
    ArrayList<CountAnimalsInZoo> getCountAnimalInZoo();
}
