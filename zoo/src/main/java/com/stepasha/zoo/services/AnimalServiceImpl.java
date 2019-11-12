package com.stepasha.zoo.services;

import com.stepasha.zoo.models.Animal;
import com.stepasha.zoo.repos.AnimalRepository;
import com.stepasha.zoo.repos.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
//todo 6 impl the service
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    private AnimalRepository animalrepo;
    @Autowired
    private ZooRepository zoorepo;


    @Override
    public List<Animal> findAll() {
        List<Animal> list = new ArrayList<>();
        animalrepo.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Animal findAnimalById(long id) {

            return animalrepo.findById(id).orElseThrow(() -> new EntityNotFoundException("could not find the animal@"));
    }

    @Override
    public void delete(long id) {
        animalrepo.findById(id).orElseThrow(() -> new EntityNotFoundException("no sir"));
        animalrepo.deleteById(id);
    }

    @Override
    public Animal save(Animal animal) {
        Animal newAnimal = new Animal();
        newAnimal.setAnimaltype(animal.getAnimaltype());
        if (animal.getZooanimals().size() > 0) throw new EntityNotFoundException("ZooAnimals not created through animal");
        return animalrepo.save(animal);
    }

    @Override
    public Animal update(long id, Animal animal) {

        if (animal.getAnimaltype() == null) throw new EntityNotFoundException("No animal type to update");
        if (animal.getZooanimals().size() > 0) throw new EntityNotFoundException("Zooanimals not updated through animal");

        if (animalrepo.findById(id) != null) {
            animalrepo.updateAnimaltype(id, animal.getAnimaltype());
        } else throw new EntityNotFoundException("No animal with id " + id + " exists");
        return findAnimalById(id);
    }
}
