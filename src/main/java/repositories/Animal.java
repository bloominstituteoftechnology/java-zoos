package repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface Animal extends CrudRepository<Animal,Long>{
}

    @Query(value = "Select a.animalid, a.animaltype, count(z.zooid) as Countzoos FROM zooanimals z RIGHT JOIN animals a " +
            "ON z.animalid=a.animalid GROUP BY a.animalid, a.animaltype", nativeQuery = true )
    ArrayList< CountAnimalsInZoo> getCountAnimalInZoo();

}
