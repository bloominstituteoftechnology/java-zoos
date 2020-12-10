package com.lambdaschool.zoos.models;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ZooAnimalsId implements Serializable
{
    private long zoo;

    private long animal;

    public ZooAnimalsId()
    {
    }

    public long getZoo()
    {
        return zoo;
    }

    public void setZoo(long zoo)
    {
        this.zoo = zoo;
    }

    public long getAnimal()
    {
        return animal;
    }
    
    public void setAnimal(long animal)
    {
        this.animal = animal;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        // boolean temp = (o.getClass() instanceof Class);
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        ZooAnimalsId that = (ZooAnimalsId) o;
        return zoo == that.zoo &&
            animal == that.animal;
    }

    @Override
    public int hashCode()
    {
        return 37;
    }
}
