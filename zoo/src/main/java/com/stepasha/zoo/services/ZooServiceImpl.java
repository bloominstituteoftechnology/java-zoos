package com.stepasha.zoo.services;

import com.stepasha.zoo.models.Telephone;
import com.stepasha.zoo.models.Zoo;
import com.stepasha.zoo.repos.AnimalRepository;
import com.stepasha.zoo.repos.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;

@Service(value = "zooService")
public class ZooServiceImpl implements ZooService{

    @Autowired
    private ZooRepository zoorepo;
    @Autowired
    private AnimalRepository animalRepo;


    @Override
    public ArrayList<Zoo> findAllZoos() {
       ArrayList<Zoo> list = new ArrayList<>();
       zoorepo.findAll().iterator().forEachRemaining(list::add);
       return list;
    }

    @Override
    public Zoo findZooById(long id) {
        return zoorepo.findById(id)
                .orElseThrow(()-> new EntityNotFoundException(Long.toString(id)));
    }

    @Override
    public Zoo findZooByName(String name) throws EntityNotFoundException{
        Zoo zoo = zoorepo.findByZooname(name);

        if (zoo == null)
        {
            throw new EntityNotFoundException("Zoo " + name + " not found!");
        }
        return zoo;
    }
    @Transactional
    @Override
    public void deleteZoo(long id)     {
        zoorepo.findById(id);
        zoorepo.deleteById(id);
    }
@Transactional
    @Override
    public Zoo saveZoo(Zoo zoo) {
        Zoo newZoo = new Zoo();
        newZoo.setZooname(zoo.getZooname());

        for(Telephone t: zoo.getTelephones()){
            newZoo.getTelephones().add(new Telephone(t.getPhonetype(), t.getPhonenumber(), newZoo));
        }
        return zoorepo.save(newZoo);
    }
@Transactional
    @Override
    public Zoo updateZoo(Zoo zoo, long id) {
    Zoo currentZoo = findZooById(id);
    if (zoo.getZooname() != null) {
        currentZoo.setZooname(zoo.getZooname());
    }
    if (zoo.getTelephones() != null) {
        for (Telephone t : zoo.getTelephones()) {
            currentZoo.getTelephones().add(new Telephone(t.getPhonetype(), t.getPhonenumber(), currentZoo));
        }
    }
    return zoorepo.save(currentZoo);

    }

    @Override
    public void deleteZooAnimal(long zooid, long animalid) {
        zoorepo.findById(zooid).orElseThrow(() -> new EntityNotFoundException("Zoo id " + zooid + " not found"));
        animalRepo.findById(zooid).orElseThrow(() -> new EntityNotFoundException("Zoo id " + animalid + " not found"));

        if (animalRepo.checkZooAnimalCombo(zooid, animalid).getCount() > 0) {
            animalRepo.deleteZooAnimals(zooid, animalid);
        } else throw new EntityNotFoundException("Zoo Animal Combo does not exist");
    }

    @Override
    public void addZooAnimal(long zooid, long animalid) {
        zoorepo.findById(zooid).orElseThrow(() -> new EntityNotFoundException("Zoo id " + zooid + " not found"));
        animalRepo.findById(zooid).orElseThrow(() -> new EntityNotFoundException("Zoo id " + animalid + " not found"));

        if (animalRepo.checkZooAnimalCombo(zooid, animalid).getCount() <= 0) {
            animalRepo.insertZooanimal(zooid, animalid);
        } else throw new EntityNotFoundException("Zoo animal combo already exists");
    }
}

