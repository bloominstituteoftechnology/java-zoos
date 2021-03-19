package com.lambdaschool.zoo.services;

import com.lambdaschool.zoo.models.Zoo;

import java.util.ArrayList;

public interface ZooServices {
    ArrayList<Zoo> findAll();

    Zoo findZooById(long id) throws Throwable;

    Zoo save(Zoo newZoo);

    Zoo update(Zoo patchedZoo);

    void delete(long id);
}
