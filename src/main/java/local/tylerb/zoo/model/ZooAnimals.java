package local.tylerb.zoo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.catalina.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "zooanimals")
public class ZooAnimals extends Auditable implements Serializable {

    //TODO Why does this need to be serializable? It has something to-do with the hash code and equals but what?

    @Id
    @ManyToOne
    @JoinColumn(name = "zooid")
    @JsonIgnoreProperties("zooanimals")
    private Zoo zoo;

    @Id
    @ManyToOne
    @JoinColumn(name = "animalid")
    @JsonIgnoreProperties("zooanimals")
    private Animal animal;

    public ZooAnimals(){}

    public ZooAnimals(Zoo zoo, Animal animal) {
        this.zoo = zoo;
        this.animal = animal;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ZooAnimals)) return false;
        ZooAnimals that = (ZooAnimals) o;
        return Objects.equals(getZoo(), that.getZoo()) &&
                Objects.equals(getAnimal(), that.getAnimal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getZoo(), getAnimal());
    }
}
