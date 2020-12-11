package com.lambdaschool.javazoos.services;


import com.lambdaschool.javazoos.models.Animal;
import com.lambdaschool.javazoos.models.Telephone;
import com.lambdaschool.javazoos.models.Zoo;
import com.lambdaschool.javazoos.models.ZooAnimals;
import com.lambdaschool.javazoos.repository.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "zooServices")
public class ZooServicesImpl implements ZooServices
{
    @Autowired
    private ZooRepository zoorepos;

    @Autowired
    private AnimalServices animalServices;


    @Override
    public List<Zoo> findAllZoos()
    {
        List<Zoo> rtnList = new ArrayList<>();
        zoorepos.findAll().iterator().forEachRemaining(rtnList::add);
        return rtnList;
    }

    @Override
    public Zoo findZooById(long id)
    {
        return zoorepos.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Zoo id " + id + " Not Found"));
    }


    @Transactional
    @Override
    public Zoo save(Zoo zoo)
    {
        Zoo newZoo = new Zoo();

        if (zoo.getZooid() != 0) {
            zoorepos.findById(zoo.getZooid())
                .orElseThrow(() -> new EntityNotFoundException("Zoo id " + zoo.getZooid() + " Not Found"));
            newZoo.setZooid(zoo.getZooid());
        }

        newZoo.setZooname(zoo.getZooname());

        newZoo.getTelephones().clear();
        for(Telephone t : zoo.getTelephones())
        {
            newZoo.getTelephones()
                .add(new Telephone(t.getPhonetype(), t.getPhonenumber()));
        }

        newZoo.getAnimals().clear();
        for (ZooAnimals za : zoo.getAnimals())
        {
            Animal newAnimal = animalServices.findAnimalById(za.getAnimal().getAnimalid());

            newZoo.getAnimals()
                .add(new ZooAnimals(newZoo, newAnimal, null));
        }
        return zoorepos.save(newZoo);
    }
}
