package com.lambdaschool.zoos.services;

import com.lambdaschool.zoos.models.Animal;
import com.lambdaschool.zoos.views.AnimalCounts;

import java.util.List;

public interface AnimalService {

    List<AnimalCounts> getAnimalCounts();


}
