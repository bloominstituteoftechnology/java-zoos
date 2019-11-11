package com.stepasha.zoo.repos;

import com.stepasha.zoo.models.Zoo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ZooRepository extends CrudRepository<Zoo, Long>{

    Zoo findByZooname(String name);
    @Modifying
    @Query(value = "INSERT INTO zooanimals (zooid, animalid) VALUES (:zooid, :animalid)", nativeQuery = true)
    void saveZooAnimalCombo(long zooid, long animalid);
}
