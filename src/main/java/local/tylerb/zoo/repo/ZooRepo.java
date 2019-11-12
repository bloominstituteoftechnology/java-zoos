package local.tylerb.zoo.repo;

import local.tylerb.zoo.model.Zoo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ZooRepo extends CrudRepository<Zoo, Long> {

    List<Zoo> findByZoonameContainingIgnoreCase(String name);
}
