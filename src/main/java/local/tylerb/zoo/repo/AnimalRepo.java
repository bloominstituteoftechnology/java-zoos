package local.tylerb.zoo.repo;

import local.tylerb.zoo.model.Animal;
import local.tylerb.zoo.model.Zoo;
import org.springframework.data.repository.CrudRepository;

public interface AnimalRepo extends CrudRepository<Animal, Long> {
}
