package com.lambdaschool.zoos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "telephones")
public class Telephone {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long phoneid;

  @Column(nullable = false)
  @Size(min = 10,max = 10, message = "Invalid length for telephone number")
  @Pattern(message = "Invalid telephone pattern. Use 123456789", regexp = "(^$|[0-9]{10})")
  private String phonenumber;

  @Column(nullable = false)
  private String phonetype;

  @ManyToOne
  @JoinColumn(name = "zooid")
  @JsonIgnoreProperties(value = "telephones",
    allowSetters = true)
  private Zoo zoo;

  public Telephone() {
  }

  public Telephone(
      String phonenumber,
      String phonetype,
      Zoo zoo) {
    this.phonenumber = phonenumber;
    this.phonetype = phonetype;
    this.zoo = zoo;
  }

  public long getPhoneid() {
    return phoneid;
  }

  public void setPhoneid(long phoneid) {
    this.phoneid = phoneid;
  }

  public String getPhonenumber() {
    return phonenumber;
  }

  public void setPhonenumber(String phonenumber) {
    this.phonenumber = phonenumber;
  }

  public String getPhonetype() {
    return phonetype;
  }

  public void setPhonetype(String phonetype) {
    this.phonetype = phonetype;
  }

  public Zoo getZoo() {
    return zoo;
  }

  public void setZoo(Zoo zoo) {
    this.zoo = zoo;
  }
}
