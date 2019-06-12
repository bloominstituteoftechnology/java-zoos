package com.jakeesveld.zoos.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

import javax.persistence.*
import java.util.ArrayList

@Entity
@Table(name = "animal")
class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var animalid: Long? = null

    var animaltype: String? = null

    @ManyToMany(mappedBy = "animalList")
    @JsonIgnoreProperties("animalList")
    var zoos: MutableList<Zoo> = mutableListOf()

    constructor() {}

    constructor(animaltype: String) {
        this.animaltype = animaltype
    }
}


