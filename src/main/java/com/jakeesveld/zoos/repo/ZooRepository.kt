package com.jakeesveld.zoos.repo

import com.jakeesveld.zoos.model.Zoo
import com.jakeesveld.zoos.view.ZooDetails
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

import java.util.ArrayList

interface ZooRepository : CrudRepository<Zoo, Long> {

    @get:Query(value = "SELECT z.zooname, a.animalid, t.phonenumber FROM zoo z INNER JOIN zooanimals a ON a.zooid=z.zooid  INNER JOIN telephone t ON t.zooid=z.zooid GROUP BY  z.zooid, a.animalid, t.phonenumber", nativeQuery = true)
    val zooDetails: MutableList<ZooDetails>

    @Modifying
    @Query(value = "DELETE FROM zooanimals WHERE zooid=:zooid", nativeQuery = true)
    fun deleteZooAnimalsEntry(zooid: Long)

    @Modifying
    @Query(value = "DELETE FROM telephone WHERE zooid=:zooid", nativeQuery = true)
    fun deleteTelephonesForZoo(zooid: Long)
}
