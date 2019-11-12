package local.tylerb.zoo.repo;

import local.tylerb.zoo.model.Animal;
import local.tylerb.zoo.model.Zoo;
import local.tylerb.zoo.view.Count;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AnimalRepo extends CrudRepository<Animal, Long> {
    @Query(value = "SELECT a.animaltype as animalname, COUNT(z.animalid) as locations FROM animal a JOIN zooanimals z ON a.animalid = z.animalid GROUP BY a.animaltype", nativeQuery = true)
    List<Count> countLocations();

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO zooanimals(zooid, animalid) VALUES (:zooid, :animalid)", nativeQuery = true)
    void insertZooAnimals(long zooid, long animalid);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM ZooAnimals WHERE zooid = :zooid AND animalid = :animailid")
    void deleteItemFromZooAnimals(long zooid,
                         long animailid);
}
