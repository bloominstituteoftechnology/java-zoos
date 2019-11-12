package local.tylerb.zoo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "zoo")
public class Zoo extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long zooid;

    private String zooname;

    // TODO why is zoo singular here
    @OneToMany(mappedBy = "zoo", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("zoo")
    private List<Telephone> telephones = new ArrayList<>();

    @OneToMany(mappedBy = "zoo", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("zoo")
    private List<ZooAnimals> zooanimals = new ArrayList<>();

    public Zoo(){}

    public Zoo(String zooname, List<ZooAnimals> zooanimals) {
        this.zooname = zooname;
        /*for (ZooAnimals za : zooAnimals) {
            za.setZoo(this);
        }*/
        this.zooanimals = zooanimals;
    }

    public long getZooid() {
        return zooid;
    }

    public void setZooid(long zooid) {
        this.zooid = zooid;
    }

    public String getZooname() {
        return zooname;
    }

    public void setZooname(String zooname) {
        this.zooname = zooname;
    }

    public List<Telephone> getTelephones() {
        return telephones;
    }

    public void setTelephones(List<Telephone> telephones) {
        this.telephones = telephones;
    }

    public List<ZooAnimals> getZooanimals() {
        return zooanimals;
    }

    public void setZooanimals(List<ZooAnimals> zooanimals) {
        this.zooanimals = zooanimals;
    }
}
