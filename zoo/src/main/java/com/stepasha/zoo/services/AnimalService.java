package com.stepasha.zoo.services;

import com.stepasha.zoo.models.Animal;
import com.stepasha.zoo.viws.AnimalCountZoos;

import java.util.List;
//todo 4 create animalService class in case of editing an animal
//todo 4 which we will need for editing animals in zoos
public interface AnimalService {
    List<Animal> findAll();

    Animal findAnimalById(long id);

    void delete(long id);

    Animal save(Animal animal);

    Animal update(long id, Animal animal);
    List<AnimalCountZoos> getCountOfAnimalPresenceAtZoos();
}
