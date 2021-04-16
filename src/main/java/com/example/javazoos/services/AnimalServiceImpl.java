package com.example.javazoos.services;

import com.example.javazoos.Views.AnimalCounts;
import com.example.javazoos.models.Animal;
import com.example.javazoos.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service(value = "animalServices")
public class AnimalServiceImpl implements AnimalService
{
    @Autowired
    private AnimalRepository animalRepository;


    @Override
    public List<AnimalCounts> getAllAnimalsAndCounts()
    {
        List<AnimalCounts> rtnList = animalRepository.FindAllAnimalsAndCounts();
        return rtnList;
    }
}
