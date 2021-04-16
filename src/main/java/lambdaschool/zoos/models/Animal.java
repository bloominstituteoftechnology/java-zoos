package lambdaschool.zoos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "animals")
public class Animal extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long animalid;

    @Column(unique = true,
            nullable = false)
    private String animaltype;

    @OneToMany(mappedBy = "zoo",
        cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "zoo",
        allowSetters = true)
    private List<Telephone> telephones = new ArrayList<>();

    @OneToMany(mappedBy = "animal",
        cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "animal",
        allowSetters = true)
    private Set<ZooAnimals> zoos = new HashSet<>();

    public Animal() {
    }

    public Animal(long animalid, String animaltype, Set<ZooAnimals> zoos) {
        this.animalid = animalid;
        this.animaltype = animaltype;
        this.zoos = zoos;
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

    public List<Telephone> getTelephones() {
        return telephones;
    }

    public void setTelephones(List<Telephone> telephones) {
        this.telephones = telephones;
    }

    public Set<ZooAnimals> getZoos() {
        return zoos;
    }

    public void setZoos(Set<ZooAnimals> zoos) {
        this.zoos = zoos;
    }
}
