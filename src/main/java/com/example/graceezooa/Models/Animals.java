package com.example.graceezooa.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "animals")
public class Animals extends Auditable
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long animalid;

    @Column(nullable = false, unique = true)
    private String animaltype;

    @OneToMany(mappedBy = "animals", cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "animal")
    private Set<ZooAnimals> zooAnimals = new HashSet<>();

    public Animals()
    {

    }

    public Animals(String animaltype)
    {
        this.animaltype = animaltype;
    }

    public long getAnimalid()
    {
        return animalid;
    }

    public void setAnimalid(long animalid)
    {
        this.animalid = animalid;
    }

    public String getAnimaltype()
    {
        return animaltype;
    }

    public void setAnimaltype(String animaltype)
    {
        this.animaltype = animaltype;
    }

    public Set<ZooAnimals> getZooAnimals()
    {
        return zooAnimals;
    }

    public void setZooAnimals(Set<ZooAnimals> zooAnimals)
    {
        this.zooAnimals = zooAnimals;
    }
}


