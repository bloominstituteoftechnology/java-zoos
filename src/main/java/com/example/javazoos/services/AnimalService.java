package com.example.javazoos.services;

import com.example.javazoos.models.Animal;

import java.util.List;

public interface AnimalService
{
    List<Animal> FindAllAnimalsAndCounts();
}
