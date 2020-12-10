package com.lambdaschool.javazoos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "animals")
public class Animal extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long animalid;

    @Column(nullable = false, unique = true)
    private String animaltype;

    @OneToMany(mappedBy = "animal",
    cascade = CascadeType.ALL,
    orphanRemoval = true)
    @JsonIgnoreProperties(value = "animal", allowSetters = true)
    private Set<ZooAnimals> zoos = new HashSet<>();

    public Animal()
    {
    }

    public Animal(String animaltype)
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

    public Set<ZooAnimals> getZoos()
    {
        return zoos;
    }

    public void setZoos(Set<ZooAnimals> zoos)
    {
        this.zoos = zoos;
    }
}
