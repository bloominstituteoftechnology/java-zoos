package lambdaschool.zoos.services;

import lambdaschool.zoos.repositories.AnimalRepository;
import lambdaschool.zoos.views.AnimalCount;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class AnimalServicesImpl implements AnimalServices{

    @Autowired
    AnimalRepository animalRepository;

    @Override
    public ArrayList<AnimalCount> getAnimalCount() {

        return animalRepository.getAnimalCount();
    }

}
