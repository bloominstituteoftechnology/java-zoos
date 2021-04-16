package com.example.javazoos.repository;

import com.example.javazoos.models.Zoo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ZoosRepository extends CrudRepository<Zoo, Long>
{

}
