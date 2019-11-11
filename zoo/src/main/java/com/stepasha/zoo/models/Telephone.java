package com.stepasha.zoo.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "telephone",
uniqueConstraints = {@UniqueConstraint(columnNames =  {"zooid", "phoneid"})})
public class Telephone extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long phoneid;
    private String phonetype;
    private String phonenumber;


    @ManyToOne
    @JoinColumn(name = "zooid",
    nullable = false)
    @JsonIgnoreProperties("phoneid")
    private Zoo zoo; //this is how you make a foreign key

    public Telephone(){}

    public Telephone(String phonetype, String phonenumber, Zoo zoo) {
        this.phonetype = phonetype;
        this.phonenumber = phonenumber;
        this.zoo =zoo;
    }

    public long getPhoneid() {
        return phoneid;
    }

    public void setPhoneid(long phoneid) {
        this.phoneid = phoneid;
    }

    public String getPhonetype() {
        return phonetype;
    }

    public void setPhonetype(String phonetype) {
        this.phonetype = phonetype;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Zoo getZoo() {
        return zoo;
    }

    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }
}
