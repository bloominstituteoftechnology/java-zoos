package com.stepasha.zoo.repos;

import com.stepasha.zoo.models.Telephone;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TelephoneRepository extends CrudRepository<Telephone, Long> {

//todo 1PHONE repo
List<Telephone> findAllByZoo_Zooid(long id);
}
