package com.jakeesveld.zoos.service

import com.jakeesveld.zoos.repo.AnimalRepository
import com.jakeesveld.zoos.view.AnimalCount
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import java.util.ArrayList

@Service
open class AnimalServiceImpl : AnimalService {

    @Autowired
    private var repo: AnimalRepository? = null

    override val animalCount: MutableList<AnimalCount>
        get() = repo!!.animalCounts
}
