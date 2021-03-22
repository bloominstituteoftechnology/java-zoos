package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.domain.Auditable;

import javax.persistence.*;

@Entity
@Table(name = "telephones")
public class Telephone extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long phoneid;

    @Column(nullable = false)
    private String phonetype;

    @Column(nullable = false)
    private String phoneNumber;


    @ManyToOne
    @JoinColumn(name = "zooid" , nullable = false)
    @JsonIgnoreProperties(value = "telephones", allowSetters = true)
    private Zoo zoo;

    public Telephone()
    {
    }

    public Telephone(String phonetype, String phoneNumber, Zoo zoo)
    {
        this.phonetype = phonetype;
        this.phoneNumber = phoneNumber;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Zoo getZoo() {
        return zoo;
    }

    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }
}
}
