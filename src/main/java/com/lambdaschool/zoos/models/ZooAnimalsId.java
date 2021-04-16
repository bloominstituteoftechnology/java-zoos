package com.lambdaschool.zoos.models;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ZooAnimalsId implements Serializable {
  private long animal;
  private long zoo;

  public ZooAnimalsId() {
  }

  public ZooAnimalsId(
      long animal,
      long zoo) {
    this.animal = animal;
    this.zoo = zoo;
  }

  public long getAnimal() {
    return animal;
  }

  public void setAnimal(long animal) {
    this.animal = animal;
  }

  public long getZoo() {
    return zoo;
  }

  public void setZoo(long zoo) {
    this.zoo = zoo;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) { return true; }

    if (! (o instanceof ZooAnimalsId)) {
      return false;
    }
    ZooAnimalsId that = (ZooAnimalsId) o;
    return (this.animal == that.animal) &&
        (this.zoo == that.zoo);
  }

  @Override
  public int hashCode() {
    //Can be any integer
    return 75;
  }
}
