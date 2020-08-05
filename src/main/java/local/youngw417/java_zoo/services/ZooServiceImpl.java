package local.youngw417.java_zoo.services;

import local.youngw417.java_zoo.models.Animal;
import local.youngw417.java_zoo.models.Telephone;
import local.youngw417.java_zoo.models.Zoo;
import local.youngw417.java_zoo.models.Zooanimals;
import local.youngw417.java_zoo.repository.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "zooService")
public class ZooServiceImpl implements ZooService{

    @Autowired
    private ZooRepository zoorepos;

    @Autowired
    private AnimalService animalService;

    @Override
    public List<Zoo> findAll() {

        List<Zoo> list = new ArrayList<>();
        /*
         * findAll returns an iterator set.
         * iterate over the iterator set and add each element to an array list.
         */
        zoorepos.findAll()
                .iterator()
                .forEachRemaining(list::add);
        return list;
    }

    @Override
    public Zoo findZooById(long zooid) {
        EntityNotFoundException

            return zoorepos.findById(zooid)
                    .orElseThrow(() -> new EntityNotFoundException("Zoo id " + zooid + " not found!"));
    }
    @Override
    public Zoo findByName(String name) {
       Zoo myzoo = zoorepos.findByZooname(name.toLowerCase());
        if (myzoo == null)
        {
            throw new EntityNotFoundException("Zoo name " + name + " not found!");
        }
        return myzoo;
    }

    @Override
    public List<Zoo> findByNameContaining(String name) {
        return zoorepos.findByZoonameContainingIgnoreCase(name.toLowerCase());
    }

    @Transactional
    @Override
    public Zoo save(Zoo zoo) {
        Zoo newZoo = new Zoo();

        if (zoo.getZooid() != 0)
        {
            zoorepos.findById(zoo.getZooid())
                    .orElseThrow(() -> new EntityNotFoundException("Zoo id " + zoo.getZooid() + " not found!"));
            newZoo.setZooid(zoo.getZooid());
        }

        newZoo.setZooname(zoo.getZooname()
                .toLowerCase());


        newZoo.getAnimals()
                .clear();
        for (Zooanimals z : zoo.getAnimals())
        {
            Animal newAnimal = animalService.findAnimalById(z.getAnimal().getAnimalid());

            newZoo.getAnimals()
                    .add(new Zooanimals(newZoo, newAnimal));
        }

        newZoo.getTelephones()
                .clear();
        for (Telephone te : zoo.getTelephones())
        {
            newZoo.getTelephones()
                    .add(new Telephone(te.getPhonetype(),te.getPhonenumber(),
                         te.getZoo());
        }

        return zoorepos.save(newZoo);
    }

    @Transactional
    @Override
    public Zoo update(Zoo zoo, long id) {
        Zoo currentZoo = findZooById(id);

        if (zoo.getZooname() != null)
        {
            currentZoo.setZooname(zoo.getZooname()
                    .toLowerCase());
        }



        if (zoo.getAnimals()
                .size() > 0)
        {
            currentZoo.getAnimals()
                    .clear();
            for (Zooanimals z : zoo.getAnimals())
            {
                Animal newAnimal = animalService.findAnimalById(z.getAnimal().getAnimalid());

                currentZoo.getAnimals()
                        .add(new Zooanimals(currentZoo, newAnimal));
            }
        }

        if (Zoo.getTelephones()
                .size() > 0)
        {
            currentZoo.getTelephones()
                    .clear();
            for (Telephone te : zoo.getTelephones())
            {
                currentZoo.getTelephones()
                        .add(new Telephone(te.getPhonetype(), te.getPhonenumber(),
                                currentZoo));
            }
    }

    @Transactional
    @Override
    public void delete(long id) {
            zoorepos.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Zoo id " + id + " not found!"));
            zoorepos.deleteById(id);
        }

    }
}
