package com.example.graceezooa.Repos;

import com.example.graceezooa.Models.Animals;
import org.springframework.data.repository.CrudRepository;

public interface AnimalRepo extends CrudRepository<Animals, Long>
{

}
