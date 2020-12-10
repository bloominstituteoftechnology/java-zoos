package com.lambdaschool.javazoos.repository;

import com.lambdaschool.javazoos.models.Zoo;
import org.springframework.data.repository.CrudRepository;

public interface ZooRepository extends CrudRepository<Zoo, Long>
{

}
