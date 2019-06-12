package com.jakeesveld.zoos.service

import com.jakeesveld.zoos.view.AnimalCount

import java.util.ArrayList

interface AnimalService {
    val animalCount: MutableList<AnimalCount>
}
