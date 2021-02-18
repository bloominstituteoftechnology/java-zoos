package com.lambda.zoo.services;


import com.lambda.zoo.repository.AnimalRepository;
import com.lambda.zoo.views.CountAnimalZoo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service(value = "animalService")
public class AnimalServiceImpl implements AnimalService{
    @Autowired
    private AnimalRepository animalrepos;

    @Override
    public ArrayList<CountAnimalZoo> getCountAnimalZoo(){
        return animalrepos.getCountAnimalInZoo();
    }
}
