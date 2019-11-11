package com.stepasha.zoo.services;

import com.stepasha.zoo.models.Zoo;

import java.util.ArrayList;

public interface ZooService {
    ArrayList<Zoo> findAllZoos();

    Zoo findZooById(long id);

    Zoo findZooByName(String name);

    void deleteZoo(long id);

    Zoo saveZoo(Zoo zoo);

    Zoo updateZoo(Zoo zoo, long id);
}