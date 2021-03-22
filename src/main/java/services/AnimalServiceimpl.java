package services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.Animal;

import java.util.ArrayList;

@Service(value = "animalService")
    public class AnimalServiceImpl implements AnimalServices
    {
        @Autowired
        private Animal animalrepos;

        @Override
        public ArrayList<CountAnimalsInZoo> getCountAnimalInZoo()
        {
            return animalrepos.getCountAnimalInZoo();
        }
}
