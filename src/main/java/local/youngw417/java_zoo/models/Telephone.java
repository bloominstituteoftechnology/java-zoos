package local.youngw417.java_zoo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "telephones")
public class Telephone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long phoneid;

    @Column(nullable =  false)
    private String phonetype;

    @Column(nullable = false)
    private String phonenumber;

    @ManyToOne
    @JoinColumn(name = "zooid")
    @JsonIgnoreProperties(value = "telephones", allowSetters = true)
    private Zoo zoo;

    public Telephone() {
    }

    public Telephone(String phonetype, String phonenumber, Zoo zoo){
        this.phonetype =  phonetype;
        this.phonenumber = phonenumber;
        this.zoo = zoo;
    }

    public long getPhoneid() {
        return phoneid;
    }

    public void setPhoneid(long phoneid) {
        this.phoneid = phoneid;
    }

    public String getPhonetype() {
        return phonetype;
    }

    public void setPhonetype(String phonetype) {
        this.phonetype = phonetype;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Zoo getZoo() {
        return zoo;
    }

    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }
}
