package com.jakeesveld.zoos.repo;

import com.jakeesveld.zoos.model.Animal;
import com.jakeesveld.zoos.view.AnimalCount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface AnimalRepository extends CrudRepository<Animal, Long> {

    @Query(value = "SELECT a.animaltype, COUNT(z.zooid) as countzoos FROM animal a INNER JOIN zooanimals z ON a.animalid=z.animalid GROUP BY a.animalid, a.animaltype", nativeQuery = true)
    ArrayList<AnimalCount> getAnimalCounts();
}
