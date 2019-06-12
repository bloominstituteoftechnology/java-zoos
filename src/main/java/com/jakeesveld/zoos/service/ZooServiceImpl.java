package com.jakeesveld.zoos.service;

import com.jakeesveld.zoos.model.Animal;
import com.jakeesveld.zoos.model.Telephone;
import com.jakeesveld.zoos.model.Zoo;
import com.jakeesveld.zoos.repo.ZooRepository;
import com.jakeesveld.zoos.view.ZooDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
public class ZooServiceImpl implements ZooService {

    @Autowired
    private ZooRepository repo;

    @Override
    public ArrayList<ZooDetails> getZooDetails() {
        return repo.getZooDetails();
    }

    @Override
    public void updateZoo(long id, Zoo updatedZoo) {
        Zoo currentZoo = repo.findById(id).orElseThrow(EntityNotFoundException::new);
        if(updatedZoo.getZooname() != null){
            currentZoo.setZooname(updatedZoo.getZooname());
        }
        if(updatedZoo.getTelephones().size() > 0){
            for (Telephone telephone: updatedZoo.getTelephones()){
                currentZoo.getTelephones().add(telephone);
            }
        }
        if(updatedZoo.getAnimalList().size() > 0){
            for (Animal animal: updatedZoo.getAnimalList()){
                currentZoo.getAnimalList().add(animal);
            }
        }

        repo.save(currentZoo);

    }

    @Override
    public void addZoo(Zoo zoo) {
        repo.save(zoo);
    }

    @Transactional
    @Override
    public void deleteZoo(long id) {
        if (repo.findById(id).isPresent()) {
            repo.deleteZooAnimalsEntry(id);
            repo.deleteTelephonesForZoo(id);
            repo.deleteById(id);
        } else {
            throw new EntityNotFoundException("Unable to find zoo with id: " + id);
        }
    }

    @Override
    public ArrayList<Zoo> findAll() {
        ArrayList<Zoo> zooList = new ArrayList<>();
        repo.findAll().iterator().forEachRemaining(zooList::add);
        return zooList;
    }
}
