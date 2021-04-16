package com.lambdaschool.zoos.repositories;

import com.lambdaschool.zoos.models.ZooAnimals;
import com.lambdaschool.zoos.models.ZooAnimalsId;
import org.springframework.data.repository.CrudRepository;

public interface ZooAnimalReposiory extends CrudRepository<ZooAnimals, ZooAnimalsId> {
}
