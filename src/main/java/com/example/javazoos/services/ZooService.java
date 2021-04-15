package com.example.javazoos.services;

import com.example.javazoos.models.Zoo;

import java.util.List;

public interface ZooService
{
    List<Zoo> findAllZoos();
    Zoo findByZooId(long zooid);
}
