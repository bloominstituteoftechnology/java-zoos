package com.lambdaschool.zoo.services;

import com.lambdaschool.zoo.repository.AnimalRepository;
import com.lambdaschool.zoo.views.CountAnimalsInZoo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AnimalServicesImpl implements AnimalServices{
    @Autowired
    AnimalRepository animalRepository;

    @Override
    public ArrayList<CountAnimalsInZoo> getCountAnimalInZoo() {
        return animalRepository.getCountAnimalInZoo();
    }
}
