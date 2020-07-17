package com.example.graceezooa.Models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "telephones")
public class Telephones extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long phoneid;

    @Column(nullable = false)
    private String phonenumber;
    private String phonetype;

    @ManyToOne()
    @JoinColumn(name = "zooid", nullable = false)
    @JsonIgnoreProperties(value = "telephones")
    private Zoo zoo;

    public Telephones()
    {
    }

    public Telephones(String phonenumber, String phonetype, Zoo zoo)
    {
        this.phonenumber = phonenumber;
        this.phonetype = phonetype;
        this.zoo = zoo;
    }

    public long getPhoneid()
    {
        return phoneid;
    }

    public void setPhoneid(long phoneid)
    {
        this.phoneid = phoneid;
    }

    public String getPhonenumber()
    {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber)
    {
        this.phonenumber = phonenumber;
    }

    public String getPhonetype()
    {
        return phonetype;
    }

    public void setPhonetype(String phonetype)
    {
        this.phonetype = phonetype;
    }

    public Zoo getZoo()
    {
        return zoo;
    }

    public void setZoo(Zoo zoo)
    {
        this.zoo = zoo;
    }
}
