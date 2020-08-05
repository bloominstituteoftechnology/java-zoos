package local.youngw417.java_zoo.services;

import local.youngw417.java_zoo.models.Animal;
import local.youngw417.java_zoo.repository.AnimalRepository;
import local.youngw417.java_zoo.repository.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Override
public class AnimalServiiceImpl implements AnimalService {

    @Autowired
    AnimalRepository animalrepos;

    /**
     * Connect this service to the User Model
     */
    @Autowired
    ZooRepository zoorepos;

    @Autowired
    private UserAuditing userAuditing;

    @Override
    public List<Animal> findAll()
    {
    List<Animal> list = new ArrayList<>();
    /*
     * findAll returns an iterator set.
     * iterate over the iterator set and add each element to an array list.
     */
        animalrepos.findAll()
                .iterator()
                .forEachRemaining(list::add);
        return list;
}


    @Override
    public Animal findAnimalById(long id)
    {
        return animalrepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Animal id " + id + " not found!"));
    }

    @Override
    public Animal findByName(String name)
    {
    Animal an = animalrepos.findByNameIgnoreCase(name);

        if (an != null)
    {
        return an;
    } else
    {
        throw new EntityNotFoundException(name);
    }
}

    @Transactional
    @Override
    public Animal save(Animal animal){

     if (animal.getZoos()
             .size() > 0)
    {
        throw new EntityExistsException("Zoo animals are not updated through Animal.");
    }

        return animalrepos.save(animal);
}

    @Transactional
    @Override
    public void deleteAll()
    {
        animalrepos.deleteAll();
    }

    @Transactional
    @Override
    public Animal update(long id, Animal animal) {
        if (animal.getName() ==  null){
            throw new EntityNotFoundException("No animal name found to update");
        }

        if (animal.getZoos().size() > 0){
            throw new EntityNotFoundException("Zoo are not updated through Animal. See endpoint POST: zoos/zoo/{zooid}/animal/{animalid}");
        }

        Animal newAnimal = findAnimalById(id);
        animalrepos.updateAnimalName(userAuditing.getCurrentAuditor().get(), id, animal.getName());
        return newAnimal;
    }
}
