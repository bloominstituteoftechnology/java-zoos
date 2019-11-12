package local.tylerb.zoo.repo;

import local.tylerb.zoo.model.Zoo;
import org.springframework.data.repository.CrudRepository;

public interface ZooRepo extends CrudRepository<Zoo, Long> {
}
