package com.jakeesveld.zoos.service

import com.jakeesveld.zoos.model.Zoo
import com.jakeesveld.zoos.view.ZooDetails

import java.util.ArrayList

interface ZooService {

    val zooDetails: MutableList<ZooDetails>
    fun updateZoo(id: Long, updatedZoo: Zoo)
    fun addZoo(zoo: Zoo)
    fun deleteZoo(id: Long)
    fun findAll(): List<Zoo>
}
