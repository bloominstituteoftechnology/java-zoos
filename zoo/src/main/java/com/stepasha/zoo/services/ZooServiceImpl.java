package com.stepasha.zoo.services;

import com.stepasha.zoo.models.Zoo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service(value = "zooService")
public class ZooServiceImpl implements ZooService{

    @Override
    public ArrayList<Zoo> findAllZoos() {
        return null;
    }

    @Override
    public Zoo findZooById(long id) {
        return null;
    }

    @Override
    public Zoo findZooByName(String name) {
        return null;
    }

    @Override
    public void deleteZoo(long id) {

    }

    @Override
    public Zoo saveZoo(Zoo zoo) {
        return null;
    }

    @Override
    public Zoo updateZoo(Zoo zoo, long id) {
        return null;
    }
}

