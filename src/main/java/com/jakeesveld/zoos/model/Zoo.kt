package com.jakeesveld.zoos.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

import javax.persistence.*

@Entity
@Table(name = "zoo")
class Zoo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var zooid: Long? = null

    var zooname: String? = null

    @OneToMany(mappedBy = "zoo")
    @JsonIgnoreProperties("zoo")
    var telephones: MutableList<Telephone> = mutableListOf()

    @ManyToMany
    @JsonIgnoreProperties("zoos")
    @JoinTable(name = "zooanimals", joinColumns = [JoinColumn(name = "zooid")], inverseJoinColumns = [JoinColumn(name = "animalid")])
    var animalList: MutableList<Animal> = mutableListOf()

    constructor() {}

    constructor(zooname: String) {
        this.zooname = zooname
    }
}
