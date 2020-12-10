package com.lambdaschool.javazoos.services;

import com.lambdaschool.javazoos.repository.AnimalRepository;
import com.lambdaschool.javazoos.views.AnimalCounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service(value = "animalService")
public class AnimalServicesImpl implements AnimalServices
{
    @Autowired
    private AnimalRepository animalrepos;

    @Override
    public List<AnimalCounts> findAnimalCounts()
    {
        List<AnimalCounts> rtnList = animalrepos.findAnimalCounts();
        return rtnList;
    }
}
