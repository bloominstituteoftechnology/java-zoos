package com.lambdaschool.zoos.services;

import com.lambdaschool.zoos.models.Animal;
import com.lambdaschool.zoos.repositories.AnimalRepository;
import com.lambdaschool.zoos.views.AnimalCounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Transactional
@Service(value = "animalService")
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    private AnimalRepository animalrepos;


    @Override
    public List<AnimalCounts> getAnimalCounts() {
        List<AnimalCounts> list = animalrepos.findAnimalCounts();
        return list;
    }
}