package local.youngw417.java_zoo.repository;

import local.youngw417.java_zoo.controllers.AnimalController;
import local.youngw417.java_zoo.models.Animal;
import local.youngw417.java_zoo.views.AnimalCount;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnimalRepository  extends CrudRepository<Animal, Long> {


    Animal findByAnimaltype(String type);
    @Modifying
    @Query(value = "UPDATE animal SET animaltype = :type, last_modified_by = :uname, last_modified_date = CURRENT_TIMESTAMP WHERE animalid = :animalid", nativeQuery = true)
    void updateAnimalType(String uname, long animalid, String type);

    @Query(value = "SELECT animaltype as type, count(animalid) as count FROM ANIMAL GROUP BY animaltype;", nativeQuery = true)
    List<AnimalCount> getAnimalCount();

}
