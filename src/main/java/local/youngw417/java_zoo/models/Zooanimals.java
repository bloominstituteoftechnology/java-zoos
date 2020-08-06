package local.youngw417.java_zoo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = " zooanimals")
public class Zooanimals extends Auditable implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "zooid")
    @JsonIgnoreProperties(value = "animals", allowSetters = true)
    private Zoo zoo;

    @Id
    @ManyToOne
    @JoinColumn(name = "animalid")
    @JsonIgnoreProperties(value = "zoos", allowSetters = true)
    private Animal animal;

    public Zooanimals() {
    }

    public Zooanimals(Zoo zoo, Animal animal) {
        this.animal = animal;
        this.zoo = zoo;
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
        if (!(o instanceof Zooanimals)) return false;

        Zooanimals that = (Zooanimals) o;

        return ((this.zoo == null) ? 0 : this.zoo.getZooid()) == ((that.zoo == null) ? 0 : that.zoo.getZooid()) &&
                ((this.animal == null) ? 0 : this.animal.getAnimalid()) == ((that.animal == null ? 0 : that.animal.getAnimalid()));
    }

    @Override
    public int hashCode() {
//        return Objects.hash(zoo, animal);
          return 37;
    }
}
