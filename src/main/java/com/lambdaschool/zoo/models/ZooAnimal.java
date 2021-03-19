package com.lambdaschool.zoo.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "zooanimals")
@IdClass(ZooAnimalId.class)
public class ZooAnimal extends Auditable implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "zooid")
    @JsonIgnoreProperties(value = "animals", allowSetters = true)
    private Zoo zoo;

    @Id
    @ManyToOne
    @JoinColumn(name = "animalid")
    @JsonIgnoreProperties(value = "zoos", allowSetters = true)
    private Animal animal;

    private String incomingzoo;

    public ZooAnimal() {
    }

    public ZooAnimal(Zoo zoo, Animal animal, String incomingzoo) {
        this.zoo = zoo;
        this.animal = animal;
        this.incomingzoo = incomingzoo;
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

    public String getIncomingzoo() {
        return incomingzoo;
    }

    public void setIncomingzoo(String incomingzoo) {
        this.incomingzoo = incomingzoo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZooAnimal that = (ZooAnimal) o;
        return          ((this.getZoo() == null) ? 0 : this.getZoo().getZooid()) ==
                        ((that.getZoo() == null) ? 0 : that.getZoo().getZooid()) &&
                        ((this.getZoo() == null) ? 0 : this.getAnimal().getAnimalid()) ==
                        ((that.getAnimal() == null) ? 0 : that.getAnimal().getAnimalid());
    }

    @Override
    public int hashCode() {
        return 297;
    }
}
