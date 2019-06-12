package com.jakeesveld.zoos.service;

import com.jakeesveld.zoos.model.Zoo;
import com.jakeesveld.zoos.view.ZooDetails;

import java.util.ArrayList;

public interface ZooService {

    ArrayList<ZooDetails> getZooDetails();
    void updateZoo(long id, Zoo updatedZoo);
    void addZoo(Zoo zoo);
    void deleteZoo(long id);
    ArrayList<Zoo> findAll();
}
