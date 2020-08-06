package local.youngw417.java_zoo.services;

import local.youngw417.java_zoo.models.Telephone;

import java.util.List;

public interface TelephoneService {


    List<Telephone> findAll();


    Telephone findTelephoneById(long id);


    void delete(long id);


    Telephone update(
            long phoneid,
            String phonenumber);


    Telephone save(
            long zooid,
            String phonenumber);
}
