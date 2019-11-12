package com.stepasha.zoo.services;

import com.stepasha.zoo.models.Telephone;

import java.util.List;

//todo 2PHONE
public interface TelephoneService {

    List<Telephone> findAll();

    Telephone findTelephoneById(long id);

    List<Telephone> findByZooId(long id);

    void delete(long id);

    Telephone update(long phoneid, String phonenumber);
}
