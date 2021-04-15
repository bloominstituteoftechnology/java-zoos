package com.lambdaschool.zoos.repositories;

import com.lambdaschool.zoos.models.ZooAnimal;
import com.lambdaschool.zoos.models.ZooAnimalId;
import org.springframework.data.repository.CrudRepository;

public interface ZooAnimalReposiory extends CrudRepository<ZooAnimal, ZooAnimalId> {
}
