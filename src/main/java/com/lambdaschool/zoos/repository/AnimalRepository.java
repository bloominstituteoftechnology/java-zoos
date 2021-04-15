package com.lambdaschool.zoos.repository;

import com.lambdaschool.zoos.models.Animal;
import com.lambdaschool.zoos.views.AnimalCounts;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnimalRepository extends CrudRepository<Animal, Long> {

  /**
   * JPA Query to find a role by name case insensitive search
   *
   * @param animaltype the name of the role which you seek
   * @return the first role matching the given name using a case insensitive search
   */
  Animal findByAnimaltype(String animaltype);

  @Query(value = "SELECT a.animaltype name, " +
      "count(animalid) countanimals " +
      "FROM animals a " +
      "GROUP By a.animaltype " +
      "ORDER BY countanimals DESC",
      nativeQuery = true)
  List<AnimalCounts> findAnimalCounts();
}
