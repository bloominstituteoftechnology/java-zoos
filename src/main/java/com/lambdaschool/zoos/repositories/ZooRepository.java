package com.lambdaschool.zoos.repositories;

import com.lambdaschool.zoos.models.Zoo;
import com.lambdaschool.zoos.views.JustTheCount;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;


public interface ZooRepository extends CrudRepository<Zoo, Long>
{
    ArrayList<Zoo> findByZoonameContainingIgnoringCase(String name);
}
