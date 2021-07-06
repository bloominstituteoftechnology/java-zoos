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
            String incomingZooAnimal = za.getIncomingzoo();
            Animal newAnimal = animalServices.findAnimalById(za.getAnimal().getAnimalid());

            newZoo.getAnimals()
                .add(new ZooAnimals(newZoo, newAnimal, incomingZooAnimal));
        }
        return zoorepos.save(newZoo);
    }

        @Transactional
        @Override
        public void deleteZooById(long id)
        {
            zoorepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Zoo id " + id + " Not Found"));
            zoorepos.deleteById(id);
        }

        @Transactional
        @Override
        public Zoo updateZooById(Zoo zoo, long id)
        {
            Zoo currentZoo = zoorepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Zoo Id " + id + " Not Found"));


            if (zoo.getZooname() != null)
            {
                currentZoo.setZooname(zoo.getZooname());
            }

            if (zoo.getAnimals().size() > 0)
            {
                currentZoo.getAnimals().clear();
                for (ZooAnimals za : zoo.getAnimals())
                {
                    Animal newAnimal = animalServices.findAnimalById(za.getAnimal().getAnimalid());

                    currentZoo.getAnimals().add(new ZooAnimals(currentZoo, newAnimal, za.getIncomingzoo()));
                }
            }

            if(zoo.getTelephones().size() > 0){
                currentZoo.getTelephones().clear();
                for (Telephone t : zoo.getTelephones())
                {
                    Telephone newTelephone = new Telephone();
                    newTelephone.setPhonetype(t.getPhonetype());
                    newTelephone.setPhonenumber(t.getPhonenumber());

                    newTelephone.setZoo(currentZoo);
                    currentZoo.getTelephones().add(newTelephone);
                }
            }

//            if (zoo.getTelephones().size() > 0)
//            {
//                currentZoo.getTelephones().clear();
//                for (Telephone t : zoo.getTelephones())
//                {
//                    currentZoo.getTelephones()
//                        .add(new Telephone(t.getPhonetype(), t.getPhonenumber()));
//                }
//            }

            return zoorepos.save(currentZoo);
        }

}
