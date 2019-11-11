package com.stepasha.zoo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "animal")
public class Animal extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long animalid;

    private String animaltype;

    @ManyToMany(mappedBy = "animals")
    @JsonIgnoreProperties("animals")
    private List<Zoo> zoos = new ArrayList<>();

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

    public List<Zoo> getZoos()
    {
        return zoos;
    }

    public void setZoos(List<Zoo> zoos)
    {
        this.zoos = zoos;
    }

    @Override
    public String toString()
    {
        return "Animal{" + "animalid=" + animalid + ", animaltype='" + animaltype + '\'' + ", zoos=" + zoos + '}';
    }
}
