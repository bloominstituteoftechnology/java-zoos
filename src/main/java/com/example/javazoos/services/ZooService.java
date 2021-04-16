package com.example.javazoos.services;

import com.example.javazoos.models.Zoo;

import java.util.List;

public interface ZooService
{
    Zoo findByZooId(long zooid);

    List<Zoo> findAll();

}
