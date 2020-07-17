package com.example.graceezooa.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "zoos")
public class Zoo extends Auditable
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long zooid;

    @Column(nullable = false, unique = true)
    private String zooname;

    @OneToMany(mappedBy = "zoo", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value = "zoo")
    private List<Telephones> telephonesList = new ArrayList<>();

    @OneToMany(mappedBy = "zoo", cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "zoo")
    private Set<ZooAnimals> zooAnimals = new HashSet<>();

    public Zoo()
    {
    }

    public Zoo(String zooname)
    {
        this.zooname = zooname;
    }

    public long getZooid()
    {
        return zooid;
    }

    public void setZooid(long zooid)
    {
        this.zooid = zooid;
    }

    public String getZooname()
    {
        return zooname;
    }

    public void setZooname(String zooname)
    {
        this.zooname = zooname;
    }

    public List<Telephones> getTelephonesList()
    {
        return telephonesList;
    }

    public void setTelephonesList(List<Telephones> telephonesList)
    {
        this.telephonesList = telephonesList;
    }

    public Set<ZooAnimals> getZooAnimals()
    {
        return zooAnimals;
    }

    public void setZooAnimals(Set<ZooAnimals> zooAnimals)
    {
        this.zooAnimals = zooAnimals;
    }
}
