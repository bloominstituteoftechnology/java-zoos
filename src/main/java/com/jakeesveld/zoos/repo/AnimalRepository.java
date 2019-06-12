package com.jakeesveld.zoos.repo;

import com.jakeesveld.zoos.model.Animal;
import org.springframework.data.repository.CrudRepository;

public interface AnimalRepository extends CrudRepository<Animal, Long> {
}
