package com.lambda.zoo.services;

import com.lambda.zoo.models.Animal;
import com.lambda.zoo.models.Telephone;
import com.lambda.zoo.models.Zoo;
import com.lambda.zoo.models.ZooAnimals;
import com.lambda.zoo.repository.AnimalRepository;
import com.lambda.zoo.repository.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;

@Service(value = "zooService")
public class ZooServiceImpl implements ZooService{
    @Autowired
    private ZooRepository zoorepos;

    @Autowired
    private AnimalRepository animalrepos;

    @Override
    public ArrayList<Zoo> findAll() {
        ArrayList<Zoo> list = new ArrayList<>();
        zoorepos.findAll().iterator().forEachRemaining(list ::add);
        return list;
    }

    @Override
    public Zoo findZooById(long id) {
        return zoorepos.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Dont find Zoo id :"+ id));
    }

    @Transactional
    @Override
    public Zoo save(Zoo zoo) {
        Zoo newZoo = new Zoo();
        if(zoo.getZooid()!= 0){
            Zoo oldZoo = zoorepos.findById(zoo.getZooid())
                    .orElseThrow(() -> new EntityNotFoundException("Didn't find Zoo id :"+zoo.getZooid()));
            newZoo.setZooid(zoo.getZooid());
        }
        newZoo.setZooname(zoo.getZooname());

        newZoo.getAnimals().clear();
        for(ZooAnimals z : zoo.getAnimals()){
            Animal newA = animalrepos.findById(z.getAnimal().getAnimalid())
                    .orElseThrow(()-> new EntityNotFoundException("dont find Animal id :"+z.getAnimal().getAnimalid()));
            newZoo.getAnimals().add(new ZooAnimals(newZoo, newA, z.getIncomingzoo()));}

        newZoo.getTelephones().clear();
        for(Telephone t : zoo.getTelephones()){
            newZoo.getTelephones()
                    .add(new Telephone(t.getPhonetype(),t.getPhonenumber(),newZoo));
        }
        return zoorepos.save(newZoo);
    }

    @Transactional
    @Override
    public Zoo update(Zoo zoo) {
        Zoo currentZoo = zoorepos.findById(zoo.getZooid())
                    .orElseThrow(() -> new EntityNotFoundException("Didn't find Zoo id :"+zoo.getZooid()));
        if (zoo.getZooname() != null){
           currentZoo.setZooname(zoo.getZooname());
        }
        if(zoo.getAnimals().size() >0){
        for(ZooAnimals z : zoo.getAnimals()){
            Animal newA = animalrepos.findById(z.getAnimal().getAnimalid())
                    .orElseThrow(()-> new EntityNotFoundException("dont find Animal id :"+z.getAnimal().getAnimalid()));
            currentZoo.getAnimals().add(new ZooAnimals(currentZoo, newA, z.getIncomingzoo()));}
        }
        if(zoo.getTelephones().size() > 0) {
            for (Telephone t : zoo.getTelephones()) {
                currentZoo.getTelephones()
                        .add(new Telephone(t.getPhonetype(), t.getPhonenumber(), currentZoo));
            }
        }
        return zoorepos.save(currentZoo);

    }

    @Transactional
    @Override
    public void delete(long id) {
        if(zoorepos.findById(id).isPresent()){
            zoorepos.deleteById(id);
        }else{
            throw new EntityNotFoundException("Didnt find  Zoo id: "+ id);
        }
    }
}
