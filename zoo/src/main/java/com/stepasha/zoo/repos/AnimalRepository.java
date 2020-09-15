package com.stepasha.zoo.repos;

import com.stepasha.zoo.models.Animal;
import com.stepasha.zoo.viws.AnimalCountZoos;
import com.stepasha.zoo.viws.JustTheCount;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AnimalRepository extends CrudRepository<Animal, Long>
{
    //todo 2 create custom query
    @Query(value = "SELECT COUNT(*) AS count FROM zooanimals WHERE zooid = :zooid AND animalid = :animalid", nativeQuery = true)
    JustTheCount checkZooAnimalCombo(long zooid, long animalid);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM zooanimals WHERE zooid = :zooid AND animalid = :animalid",
            nativeQuery = true)
    void deleteZooAnimals(long zooid, long animalid);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO zooanimals(zooid, animalid) VALUES (:zooid, :animalid)", nativeQuery = true)
    void insertZooanimal(long zooid, long animalid);

    // returns list of animals and counts
     //SELECT a.animalid as animalnamerpt, a.animaltype, count(z.animalid) as countanimal FROM animals a JOIN zooanimals z ON z.animalid = a.animalid GROUP BY a.animalid
    @Query(value = "SELECT a.animaltype, count(z.animalid) as countanimal FROM animal a JOIN zooanimals z ON z.animalid = a.animalid GROUP BY a.animalid",
            nativeQuery = true)
    List<AnimalCountZoos> getListOfAnimalsZoos();

    @Query(value = "UPDATE animals SET animaltype = :animaltype WHERE animalid = :animalid", nativeQuery = true)
    Animal updateAnimaltype(long animalid, String animaltype);
}
