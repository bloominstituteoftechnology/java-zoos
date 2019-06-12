package com.jakeesveld.zoos.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

import javax.persistence.*

@Entity
@Table(name = "telephone")
class Telephone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var phoneid: Long? = null

    var phonetype: String? = null
    var phonenumber: String? = null

    @ManyToOne
    @JoinColumn(name = "zooid")
    @JsonIgnoreProperties("zooid")
    var zoo: Zoo? = null

    constructor() {}

    constructor(phonetype: String, phonenumber: String) {
        this.phonetype = phonetype
        this.phonenumber = phonenumber
    }
}

