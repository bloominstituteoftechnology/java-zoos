package com.jakeesveld.zoos.controller

import com.jakeesveld.zoos.model.Zoo
import com.jakeesveld.zoos.service.ZooService
import com.jakeesveld.zoos.view.ZooDetails
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class ZooController {

    @Autowired
    private var zooService: ZooService? = null

    val zooDetails: ResponseEntity<*>
        @GetMapping(value = ["/zoos/zoos"], produces = ["application/json"])
        get() = ResponseEntity(zooService!!.zooDetails, HttpStatus.OK)

    val allZoos: ResponseEntity<*>
        @GetMapping(value = ["/zoos/zoos/all"], produces = ["application/json"])
        get() = ResponseEntity(zooService!!.findAll(), HttpStatus.OK)

    @PutMapping(value = ["/admin/zoos/{id}"])
    fun updateZoo(@PathVariable id: Long, @RequestBody updatedZoo: Zoo): ResponseEntity<*> {
        zooService!!.updateZoo(id, updatedZoo)
        return ResponseEntity<Any>(HttpStatus.OK)
    }

    @PostMapping(value = ["/admin/zoos"])
    fun addZoo(@RequestBody zoo: Zoo): ResponseEntity<*> {
        zooService!!.addZoo(zoo)
        return ResponseEntity<Any>(HttpStatus.OK)
    }

    @DeleteMapping(value = ["/admin/zoos/{id}"])
    fun deleteZoo(@PathVariable id: Long): ResponseEntity<*> {
        zooService!!.deleteZoo(id)
        return ResponseEntity<Any>(HttpStatus.OK)
    }
}
