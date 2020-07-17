package com.example.graceezooa.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "zooanimals")

// extends auditble first - then implemts anythign
public class ZooAnimals extends Auditable implements Serializable
{

    @Id
    @ManyToOne
    @JoinColumn(name = "zooid")
    @JsonIgnoreProperties(value = "zooanimal")
    private Zoo zoo;

    @Id
    @ManyToOne
    @JoinColumn(name = "animalid")
    @JsonIgnoreProperties(value = "zooanimal")
    private Animals animals;


    private String incomingzoo;

    public ZooAnimals()
    {
    }

    public ZooAnimals(Zoo zoo, String incomingzoo, Animals animals)
    {
        this.zoo = zoo;
        this.incomingzoo = incomingzoo;
        this.animals = animals;
    }

    public String getIncomingzoo()
    {
        return incomingzoo;
    }

    public void setIncomingzoo(String incomingzoo)
    {
        this.incomingzoo = incomingzoo;
    }

    public Zoo getZoo()
    {
        return zoo;
    }

    public void setZoo(Zoo zoo)
    {
        this.zoo = zoo;
    }

    public Animals getAnimals()
    {
        return animals;
    }

    public void setAnimals(Animals animals)
    {
        this.animals = animals;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof ZooAnimals))
        {
            return false;
        }
       ZooAnimals that = (ZooAnimals) o;
        return ((zoo == null) ? 0 : zoo.getZooid()) == ((that.zoo == null) ? 0 : that.zoo.getZooid()) &&
                ((animals == null) ? 0 : animals.getAnimalid()) == ((that.animals == null) ? 0 : that.animals.getAnimalid());
    }
    @Override
    public int hashCode()
    {
        // return Objects.hash(user.getUserid(), role.getRoleid());
        return 37;
    }
}
