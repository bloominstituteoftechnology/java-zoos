package com.lambdaschool.zoos.repositories;

import com.lambdaschool.zoos.models.Animal;
import com.lambdaschool.zoos.views.AnimalCounts;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnimalRepository extends CrudRepository<Animal,Long> {



    @Query(value = "SELECT r.name as name, count(menuid) as countmenus " +
            "FROM restaurants r LEFT JOIN menus m " +
            "ON r.restaurantid = m.restaurantid " +
            "GROUP BY r.name " +
            "ORDER BY countmenus desc",
            nativeQuery = true)
    List<AnimalCounts> getCountAnimals();






}
