package com.jakeesveld.zoos.repo;

import com.jakeesveld.zoos.model.Zoo;
import org.springframework.data.repository.CrudRepository;

public interface ZooRepository extends CrudRepository<Zoo, Long> {
}
