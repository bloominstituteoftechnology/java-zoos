package local.youngw417.java_zoo.repository;

import local.youngw417.java_zoo.models.Animal;
import org.springframework.data.repository.CrudRepository;

public interface AnimalRepository  extends CrudRepository<Animal, Long> {
    Animal findByNameIgnoreCase(String name);
}
