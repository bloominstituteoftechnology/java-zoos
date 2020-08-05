package local.youngw417.java_zoo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "animals")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long animalid;

    @Column(nullable = false)
    private String animaltype;

    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "animals", allowSetters = true)
    private Set<Zooanimals> zoos = new HashSet<>();

    public Animal() {
    }

    public Animal(String animaltype) {

        this.animaltype = animaltype;
    }

    public long getAnimalid() {
        return animalid;
    }

    public void setAnimalid(long animalid) {
        this.animalid = animalid;
    }

    public String getAnimaltype() {
        return animaltype;
    }

    public void setAnimaltype(String animaltype) {
        this.animaltype = animaltype;
    }

    public Set<Zooanimals> getZoos() {
        return zoos;
    }

    public void setZoos(Set<Zooanimals> zoos) {
        this.zoos = zoos;
    }
}
