package repositories;

import models.Zoo;
import org.springframework.data.repository.CrudRepository;

public interface ZooRepository extends CrudRepository <Zoo,Long> {
}
