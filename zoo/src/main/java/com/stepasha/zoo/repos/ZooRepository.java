package com.stepasha.zoo.repos;

import com.stepasha.zoo.models.Zoo;
import org.springframework.data.repository.CrudRepository;

public interface ZooRepository extends CrudRepository<Zoo, Long>{

    Zoo findByZooname(String name);
}
