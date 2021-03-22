package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.domain.Auditable;

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

        @Column(nullable = false,
                unique = true)
        private String zooname;

        @OneToMany(mappedBy = "zoo", cascade = CascadeType.ALL, orphanRemoval = true)
        @JsonIgnoreProperties("zoo")
        private List<Telephone> telephoneList = new ArrayList<>();

        @OneToMany(mappedBy = "zoo", cascade = CascadeType.ALL)
        @JsonIgnoreProperties(value = "zoo", allowSetters = true)
        private Set<ZooAnimals> animals = new HashSet<>();


        public Zoo()
        {
        }

        public Zoo(long zooid, String zooname) {
            this.zooid = zooid;
            this.zooname = zooname;
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

        public List<Telephone> getTelephoneList() {
            return telephoneList;
        }

        public void setTelephoneList(List<Telephone> telephoneList) {
            this.telephoneList = telephoneList;
        }

        public Set<ZooAnimals> getAnimals() {
            return animals;
        }

        public void setAnimals(Set<ZooAnimals> animals) {
            this.animals = animals;
        }
=
    }


}
