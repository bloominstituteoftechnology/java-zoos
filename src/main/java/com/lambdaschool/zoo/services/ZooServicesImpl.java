package com.lambdaschool.zoo.services;

import com.lambdaschool.zoo.models.Animal;
import com.lambdaschool.zoo.models.Telephone;
import com.lambdaschool.zoo.models.Zoo;
import com.lambdaschool.zoo.models.ZooAnimal;
import com.lambdaschool.zoo.repository.AnimalRepository;
import com.lambdaschool.zoo.repository.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.persistence.Transient;
import javax.transaction.Transactional;
import java.util.ArrayList;

@Service(value = "zooService")
public class ZooServicesImpl implements ZooServices {
    @Autowired
    private ZooRepository zooRepository;
    @Autowired
    AnimalRepository animalRepository;

    @Override
    public ArrayList<Zoo> findAll() {
        ArrayList<Zoo> zooArrayList = new ArrayList<>();
        zooRepository.findAll().iterator().forEachRemaining(zooArrayList::add);
        return zooArrayList;
    }

    @Override
    public Zoo findZooById(long id) throws Throwable {
        return (Zoo) zooRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Zoo ID " + id + " not found."));
    }

    @Transactional
    @Override
    public Zoo save(Zoo zoo){
        Zoo newZoo = new Zoo();
        if (zoo.getZooid() != 0){
            Zoo oldZoo = zooRepository.findById(zoo.getZooid())
                    .orElseThrow(()->new EntityNotFoundException("Zoo id "+zoo.getZooid() + " not found."));
            newZoo.setZooid(zoo.getZooid());
        }
        newZoo.setZooname(zoo.getZooname());
        newZoo.getZooAnimals().clear();

        for(ZooAnimal za : zoo.getZooAnimals()) {
            Animal newAnimal = animalRepository.findById(za.getAnimal()
                    .getAnimalid())
                    .orElseThrow(()->new EntityNotFoundException("Animal id " + za.getAnimal().getAnimalid() + " not found."));
            newZoo.getZooAnimals().add(new ZooAnimal(newZoo, newAnimal, za.getIncomingzoo()));
        }
        newZoo.getTelephoneList().clear();
        for(Telephone t : zoo.getTelephoneList()){
            newZoo.getTelephoneList().add(new Telephone(
                    t.getPhonetype(), t.getPhonenumber(), newZoo));
        }
        return zooRepository.save(newZoo);
    }

    @Transactional
    @Override
    public Zoo update(Zoo zoo) {
        Zoo updatedZoo = zooRepository.findById(zoo.getZooid())
                .orElseThrow(()->new EntityNotFoundException("Zoo id " + zoo.getZooid() + " not found."));
        if (zoo.getZooname() != null){
            updatedZoo.setZooname(zoo.getZooname());
        }
        if(zoo.getZooAnimals().size() > 0){
            for(ZooAnimal za : zoo.getZooAnimals()){
                Animal newAnimal = animalRepository.findById(za.getAnimal().getAnimalid())
                        .orElseThrow(()->new EntityNotFoundException("Animal id " + za.getAnimal().getAnimalid() +" not found."));
            updatedZoo.getZooAnimals().add(new ZooAnimal(
                    updatedZoo, newAnimal, za.getIncomingzoo()));
            }
        }
        if (zoo.getTelephoneList().size() > 0) {
            updatedZoo.getZooAnimals().clear();
            for(Telephone t : zoo.getTelephoneList()) {
            updatedZoo.getTelephoneList().add(new Telephone(
                    t.getPhonetype(),t.getPhonenumber(), updatedZoo));
            }
        }
        return zooRepository.save(updatedZoo);
    }

    @Transactional
    @Override
    public void delete(long id) {
    if(zooRepository.findById(id).isPresent()){
        zooRepository.deleteById(id);
    }else throw new EntityNotFoundException("Zoo id " + id + " not found.");
    }
}
