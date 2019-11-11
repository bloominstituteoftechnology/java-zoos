package com.stepasha.zoo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Transactional
@Entity
@Table(name = "zoo")
public class Zoo extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long zooid;

    @Column(nullable = false,
    unique = true)
    private String zooname;

    @OneToMany(mappedBy = "zoo",
    cascade = CascadeType.ALL,
    orphanRemoval = true)
    @JsonIgnoreProperties("zoo")
    private List<Telephone> telephones = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "zooanimals",
            joinColumns = {@JoinColumn(name = "zooid")},
            inverseJoinColumns = {@JoinColumn(name = "animalid")})
    @JsonIgnoreProperties("zoos")
    private List<Animal> animals = new ArrayList<>();
    public Zoo(){}

    public Zoo(String zooname, List<Telephone> telephones, List<Animal> animals) {
        this.zooname = zooname;
        this.telephones = telephones;
        this.animals = animals;
    }

    public long getZooid() {
        return zooid;
    }

    public void setZooid(long zooid) {
        this.zooid = zooid;
    }

    public String getZooname() {
        return zooname.toLowerCase();
    }

    public void setZooname(String zooname) {
        this.zooname = zooname.toLowerCase();
    }

    public List<Telephone> getTelephones() {
        return telephones;
    }

    public void setTelephones(List<Telephone> telephones) {
        this.telephones = telephones;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

}
