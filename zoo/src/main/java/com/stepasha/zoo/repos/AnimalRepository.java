package com.stepasha.zoo.repos;

import com.stepasha.zoo.models.Animal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AnimalRepository extends CrudRepository<Animal, Long>
{
    Animal findByAnimaltype(String type);

   // @Query(value = "SELECT a.animalid, a.animaltype, count(z.zooid) as countzoos FROM zooanimals z INNER JOIN animal a ON z.animalid=a.animalid GROUP BY a.animalid, a.animaltype ORDER BY a.animaltype, a.animalid",
   //         nativeQuery = true)
   // ArrayList<CountAnimalsInZoos> getCountAnimalsinZoos();
}
