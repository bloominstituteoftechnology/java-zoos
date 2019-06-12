package com.jakeesveld.zoos.repo

import com.jakeesveld.zoos.model.Animal
import com.jakeesveld.zoos.view.AnimalCount
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

import java.util.ArrayList

interface AnimalRepository : CrudRepository<Animal, Long> {

    @get:Query(value = "SELECT a.animaltype, COUNT(z.zooid) as countzoos FROM animal a INNER JOIN zooanimals z ON a.animalid=z.animalid GROUP BY a.animalid, a.animaltype", nativeQuery = true)
    val animalCounts: MutableList<AnimalCount>
}
