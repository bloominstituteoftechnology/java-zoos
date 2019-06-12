package com.jakeesveld.zoos.service

import com.jakeesveld.zoos.model.Animal
import com.jakeesveld.zoos.model.Telephone
import com.jakeesveld.zoos.model.Zoo
import com.jakeesveld.zoos.repo.ZooRepository
import com.jakeesveld.zoos.view.ZooDetails
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.persistence.EntityNotFoundException
import javax.transaction.Transactional
import java.util.ArrayList
import java.util.function.Consumer
import java.util.function.Supplier

@Service
open class ZooServiceImpl : ZooService {

    @Autowired
    private var repo: ZooRepository? = null

    override val zooDetails: MutableList<ZooDetails>
        get() = repo!!.zooDetails

    override fun updateZoo(id: Long, updatedZoo: Zoo) {
        val currentZoo = repo!!.findById(id).orElseThrow<EntityNotFoundException>(Supplier<EntityNotFoundException> { EntityNotFoundException() })
        if (updatedZoo.zooname != null) {
            currentZoo.zooname = updatedZoo.zooname
        }
        if (updatedZoo.telephones.size > 0) {
            for (telephone in updatedZoo.telephones) {
                currentZoo.telephones.add(telephone)
            }
        }
        if (updatedZoo.animalList.size > 0) {
            for (animal in updatedZoo.animalList) {
                currentZoo.animalList.add(animal)
            }
        }

        repo!!.save(currentZoo)

    }

    override fun addZoo(zoo: Zoo) {
        repo!!.save(zoo)
    }

    @Transactional
    override fun deleteZoo(id: Long) {
        if (repo!!.findById(id).isPresent) {
            repo!!.deleteZooAnimalsEntry(id)
            repo!!.deleteTelephonesForZoo(id)
            repo!!.deleteById(id)
        } else {
            throw EntityNotFoundException("Unable to find zoo with id: $id")
        }
    }

    override fun findAll(): List<Zoo> {
        val zooList = mutableListOf<Zoo>()
        repo!!.findAll().iterator().forEachRemaining(Consumer<Zoo> { zooList.add(it) })
        return zooList
    }
}
