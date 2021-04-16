package com.example.javazoos.repository;

import com.example.javazoos.models.Animal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnimalRepository extends CrudRepository<Animal, Long>
{
//    @Query(value = )
//    List<Animal> FindAllAnimalsAndCounts();
}
