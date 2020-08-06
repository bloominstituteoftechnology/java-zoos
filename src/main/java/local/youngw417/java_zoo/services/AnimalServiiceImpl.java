package local.youngw417.java_zoo.services;

import local.youngw417.java_zoo.models.Animal;
import local.youngw417.java_zoo.repository.AnimalRepository;
import local.youngw417.java_zoo.repository.ZooRepository;
import local.youngw417.java_zoo.views.AnimalCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "animalService")
public class AnimalServiiceImpl implements AnimalService {

    @Autowired
    AnimalRepository animalrepos;

    /**
     * Connect this service to the User Model
     */
    @Autowired
    ZooRepository zoorepos;

    @Autowired
    private ZooAuditing zooAuditing;

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
    public Animal findByAnimaltype(String type)
    {
    Animal an = animalrepos.findByAnimaltype(type);

        if (an != null)
    {
        return an;
    } else
    {
        throw new EntityNotFoundException(type);
    }
}

    @Override
    public List<AnimalCount> getAnimalCount() {
        return animalrepos.getAnimalCount();
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
        if (animal.getAnimaltype() ==  null){
            throw new EntityNotFoundException("No animal type found to update");
        }

        if (animal.getZoos().size() > 0){
            throw new EntityNotFoundException("Zoo are not updated through Animal. See endpoint POST: zoos/zoo/{zooid}/animal/{animalid}");
        }

        Animal newAnimal = findAnimalById(id);
        animalrepos.updateAnimalType(zooAuditing.getCurrentAuditor().get(), id, animal.getAnimaltype());
        return newAnimal;
    }
}
