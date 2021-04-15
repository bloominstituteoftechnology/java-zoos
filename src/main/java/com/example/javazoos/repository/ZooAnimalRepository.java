package com.example.javazoos.repository;

import com.example.javazoos.models.ZooAnimal;
import com.example.javazoos.models.ZooAnimalId;
import org.springframework.data.repository.CrudRepository;

public interface ZooAnimalRepository extends CrudRepository<ZooAnimal, ZooAnimalId>
{
}
