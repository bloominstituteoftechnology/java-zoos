package com.lambdaschool.zoos.repositories;

import com.lambdaschool.zoos.models.Animal;
import com.lambdaschool.zoos.views.AnimalCounts;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnimalRepository extends CrudRepository<Animal,Long> {

@Query (value =
"SELECT a.animalid, a.animaltype, count(z.zooid) as countzoos " +
        "FROM zooanimals z RIGHT JOIN animals a ON z.animalid=a.animalid " +
        "GROUP BY a.animalid, a.animaltype " +
        "ORDER BY a.animaltype", nativeQuery = true)
    List<AnimalCounts> findAnimalCounts();





}
