package local.youngw417.java_zoo.repository;

import local.youngw417.java_zoo.models.Zoo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ZooRepository extends CrudRepository<Zoo, Long> {

    Zoo findByZooname(String zooname);
    List<Zoo> findByZoonameContainingIgnoreCase(String name);
}
