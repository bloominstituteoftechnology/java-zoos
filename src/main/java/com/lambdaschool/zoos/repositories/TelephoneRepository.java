package com.lambdaschool.zoos.repositories;

import com.lambdaschool.zoos.models.Telephone;
import org.springframework.data.repository.CrudRepository;

public interface TelephoneRepository extends CrudRepository<Telephone,Long> {
}
