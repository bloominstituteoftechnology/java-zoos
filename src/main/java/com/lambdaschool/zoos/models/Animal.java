package com.lambdaschool.zoos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "animals")
public class Animal extends Auditable{

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long animalid;

  @Column(nullable = false)
  private String animaltype;

  @OneToMany(mappedBy = "animal",
  cascade = CascadeType.ALL,
  orphanRemoval = true)
  @JsonIgnoreProperties(value = "animal", allowSetters = true)
  private List<Telephone> telephones = new ArrayList<>();

  @OneToMany(mappedBy = "animal",
  cascade = CascadeType.ALL,
  orphanRemoval = true)
  @JsonIgnoreProperties(value = "animal", allowSetters = true)
  private Set<ZooAnimals> animals = new HashSet<>();

  public Animal() {
  }

  public Animal(
      String animaltype) {
    this.animaltype = animaltype;
  }

  public long getAnimalid() {
    return animalid;
  }

  public void setAnimalid(long animalid) {
    this.animalid = animalid;
  }

  public String getAnimaltype() {
    return animaltype;
  }

  public void setAnimaltype(String animaltype) {
    this.animaltype = animaltype.toLowerCase();
  }

  public List<Telephone> getTelephones() {
    return telephones;
  }

  public void setTelephones(List<Telephone> telephones) {
    this.telephones = telephones;
  }

  public Set<ZooAnimals> getAnimals() {
    return animals;
  }

  public void setAnimals(Set<ZooAnimals> animals) {
    this.animals = animals;
  }
}
