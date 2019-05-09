package com.lambdaschool.javazoo.repository;

import com.lambdaschool.javazoo.model.Telephone;
import org.springframework.data.repository.CrudRepository;

public interface TelephoneRepository extends CrudRepository<Telephone, Long>
{
}
