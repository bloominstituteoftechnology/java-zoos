package com.lambdaschool.javazoos.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "zooanimals")
@IdClass(ZooAnimalsId.class)
public class ZooAnimals extends Auditable implements Serializable
{
    @Id
    @ManyToOne
    @JoinColumn(name = "zooid")
    @JsonIgnoreProperties(value = "animals")
    private Zoo zoo;

    @Id
    @ManyToOne
    @JoinColumn(name = "animalid")
    @JsonIgnoreProperties(value = "zoos")
    private Animal animal;

    public ZooAnimals()
    {
    }

    public ZooAnimals(
        Zoo zoo,
        Animal animal)
    {
        this.zoo = zoo;
        this.animal = animal;
    }

    public Zoo getZoo()
    {
        return zoo;
    }

    public void setZoo(Zoo zoo)
    {
        this.zoo = zoo;
    }

    public Animal getAnimal()
    {
        return animal;
    }

    public void setAnimal(Animal animal)
    {
        this.animal = animal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ZooAnimals)) return false;

        ZooAnimals that = (ZooAnimals) o;

        return  ((this.zoo == null) ? 0 : this.zoo.getZooid()) ==
            ((that.getZoo() == null) ? 0 : that.getZoo().getZooid()) &&
            ((this.animal == null) ? 0 : this.animal.getAnimalid()) ==
                ((that.animal == null) ? 0 : that.getAnimal().getAnimalid());
    }

    @Override
    public int hashCode()
    {
        return 1;
    }
}
