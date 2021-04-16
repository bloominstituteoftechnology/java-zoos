package com.lambdaschool.zoos.services;

import com.lambdaschool.zoos.models.Animal;
import com.lambdaschool.zoos.repository.AnimalRepository;
import com.lambdaschool.zoos.repository.ZooRepository;
import com.lambdaschool.zoos.views.AnimalCounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class AnimalServicesImpl implements AnimalServices {

  @Autowired
  AnimalRepository animalrepos;

  @Autowired
  ZooRepository zoorepos;

  @Autowired
  ZooAuditing zooAuditing;

  @Override
  public Animal findAnimalById(long id) {
    List<Animal> list = new ArrayList<>();
    return animalrepos.findById(id).orElseThrow(()->
        new EntityNotFoundException("Animal id: " + id + " not found!"));
  }

  @Override
  public List<AnimalCounts> getAnimalCounts() {
    List<AnimalCounts> rtnList = animalrepos.findAnimalCounts();
    return rtnList;
  }
}
