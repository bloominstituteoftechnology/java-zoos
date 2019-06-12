package com.jakeesveld.zoos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "zoo")
public class Zoo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long zooid;

    private String zooname;

    @OneToMany(mappedBy = "zoo")
    @JsonIgnoreProperties("zoo")
    private List<Telephone> telephones = new ArrayList<>();

    @ManyToMany
    @JsonIgnoreProperties("zoos")
    @JoinTable(name = "zooanimals", joinColumns = {@JoinColumn(name = "zooid")}, inverseJoinColumns = {@JoinColumn(name = "animalid")})
    private List<Animal> animalList = new ArrayList<>();

    public Zoo() {
    }

    public Zoo(String zooname) {
        this.zooname = zooname;
    }

    public Long getZooid() {
        return zooid;
    }

    public void setZooid(Long zooid) {
        this.zooid = zooid;
    }

    public String getZooname() {
        return zooname;
    }

    public void setZooname(String zooname) {
        this.zooname = zooname;
    }

    public List<Telephone> getTelephones() {
        return telephones;
    }

    public void setTelephones(List<Telephone> telephones) {
        this.telephones = telephones;
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(List<Animal> animalList) {
        this.animalList = animalList;
    }
}
