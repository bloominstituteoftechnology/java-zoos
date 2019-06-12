package com.jakeesveld.zoos.controller

import com.jakeesveld.zoos.service.AnimalService
import com.jakeesveld.zoos.view.AnimalCount
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class AnimalController {

    @Autowired
    private var animalService: AnimalService? = null

    val animalsCount: ResponseEntity<*>
        @GetMapping(value = ["/animals/count"], produces = ["application/json"])
        get() = ResponseEntity(animalService!!.animalCount, HttpStatus.OK)
}
