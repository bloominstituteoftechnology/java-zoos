package com.stepasha.zoo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
//todo 1 this is a custom table that was missing in reference to zooanimals
@Entity
@Table(name = "zooanimals", uniqueConstraints = {@UniqueConstraint(columnNames = {"zooid", "animalid"})})
public class ZooAnimals extends Auditable implements Serializable {
//todo 1.1 many animals belong to one zoo
    @Id
    @ManyToOne
    @JoinColumn(name = "zooid")
    @JsonIgnoreProperties(value = "zooanimals", allowSetters = true)
    private Zoo zoo;
//todo 1.2 since we are joining two tables we need another relationship
    @Id
    @ManyToOne
    @JoinColumn(name = "animalid")
    @JsonIgnoreProperties(value = "zooanimals", allowSetters = true)
    private Animal animal;

    public ZooAnimals() {
    }

    public ZooAnimals(Zoo zoo, Animal animal) {
        this.zoo = zoo;
        this.animal = animal;
    }

    public Zoo getZoo() {
        return zoo;
    }

    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ZooAnimals)) return false;
        ZooAnimals equalsAnimal = (ZooAnimals) o;
        return Objects.equals(getZoo(), equalsAnimal.getZoo()) &&
                Objects.equals(getAnimal(), equalsAnimal.getAnimal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getZoo(), getAnimal());
    }
}
