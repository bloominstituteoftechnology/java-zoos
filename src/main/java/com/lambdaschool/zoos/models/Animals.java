package com.lambdaschool.zoos.models;

import javax.persistence.*;

@Entity
@Table(name = "animals")
public class Animals {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long animalid;

  private String animaltype;

  public Animals() {
  }

  public Animals(
      long animalid,
      String animaltype) {
    this.animalid = animalid;
    this.animaltype = animaltype;
  }

  public long getAnimalid() {
    return animalid;
  }

  public void setAnimalid(long animalid) {
    this.animalid = animalid;
  }
}
