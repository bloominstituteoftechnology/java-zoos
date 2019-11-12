package com.stepasha.zoo.services;

import com.stepasha.zoo.models.Telephone;
import com.stepasha.zoo.repos.TelephoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
@Service(value = "telephoneService")
public class TelephoneServiceImpl implements TelephoneService {

    @Autowired
    TelephoneRepository telephoneRepo;

    @Override
    public List<Telephone> findAll() {
        List<Telephone> list = new ArrayList<>();
        telephoneRepo.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Telephone findTelephoneById(long id) {
            return telephoneRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("no phone found"));
    }

    @Override
    public List<Telephone> findByZooId(long id) {
        return telephoneRepo.findAllByZoo_Zooid(id);
    }

    @Override
    public void delete(long id) {
        if (telephoneRepo.findById(id).isPresent()) {
            telephoneRepo.deleteById(id);
        } else {
            throw new EntityNotFoundException("no phone to delete");
        }
    }

    @Override
    public Telephone update(long phoneid, String phonenumber) {
        if (telephoneRepo.findById(phoneid).isPresent()) {
            Telephone telephone = findTelephoneById(phoneid);
            telephone.setPhonenumber(phonenumber);
            return telephoneRepo.save(telephone);
        } else {
            throw new EntityNotFoundException("No phone to update");
        }
    }
}
