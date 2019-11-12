package local.tylerb.zoo.repo;

import local.tylerb.zoo.model.Telephone;
import local.tylerb.zoo.model.Zoo;
import org.springframework.data.repository.CrudRepository;

public interface TelephoneRepo extends CrudRepository<Telephone, Long> {
}
