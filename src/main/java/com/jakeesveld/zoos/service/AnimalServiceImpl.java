package com.jakeesveld.zoos.service;

import com.jakeesveld.zoos.repo.AnimalRepository;
import com.jakeesveld.zoos.view.AnimalCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    private AnimalRepository repo;

    @Override
    public ArrayList<AnimalCount> getAnimalCount() {
        return repo.getAnimalCounts();
    }
}
