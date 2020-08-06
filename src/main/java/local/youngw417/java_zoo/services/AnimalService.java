package local.youngw417.java_zoo.services;

import local.youngw417.java_zoo.models.Animal;
import local.youngw417.java_zoo.views.AnimalCount;

import java.util.List;

public interface AnimalService {

    List<Animal> findAll();

    /**
     * Return the first Role matching the given primary key
     *
     * @param id The primary key (long) of the Role you seek
     * @return The Role object you seek
     */
    Animal findAnimalById(long id);

    /**
     * Given a complete Role object, saved that Role object in the database.
     * If a primary key is provided, the record is completely replaced
     * If no primary key is provided, one is automatically generated and the record is added to the database.
     * <p>
     * Note that Users are not added to Roles through this process
     *
     * @param role the role object to be saved
     * @return the saved role object including any automatically generated fields
     */
    Animal save(Animal animal);

    /**
     * Find the first Role object matching the given name
     *
     * @param name The name (String) of the role you seek
     * @return The Role object matching the given name
     */
    Animal findByAnimaltype(String type);

    List<AnimalCount> getAnimalCount();

    public void deleteAll();

    Animal update(long id, Animal animal);
}
