package com.lambda.zoo.services;

import com.lambda.zoo.models.Zoo;

import java.util.ArrayList;

public interface ZooService {
    ArrayList<Zoo> findAll();

    Zoo findZooById(long id);

    Zoo save(Zoo zoo);

    Zoo update(Zoo zoo);

    void delete(long id);
}
